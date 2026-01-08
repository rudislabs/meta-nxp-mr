#!/bin/bash

if [[ $(lsb_release -c | grep "noble") ]]; then
    echo "apparmor_restrict_unprivileged_userns disabled to run bitbake, only lasts this login session."
    echo 0 | sudo tee /proc/sys/kernel/apparmor_restrict_unprivileged_userns
fi

BASE_WORK_DIR="$HOME/nxp-mr-image"
BUILD_TYPE=jazzy
BRANCH=lf-6.12.49-2.2.0-walnascar-mr
MACHINE="imx8mpnavqdesktop"
MANIFEST="imx-6.12.49-2.2.0-navqplus.xml"
DISTRO="fsl-imx-xwayland"
SETUP="imx-setup-release.sh"
BUILDDIR="build"
BUILD=`date +%Y%m%d.%H%M`; start=`date +%s`

mkdir -p ~/bin
curl https://storage.googleapis.com/git-repo-downloads/repo  > ~/bin/repo
chmod a+x ~/bin/repo
PATH=${PATH}:~/bin

mkdir -p ${BASE_WORK_DIR}
cd ${BASE_WORK_DIR}
repo init \
    -u https://github.com/rudislabs/mr-imx-manifest.git \
    -b ${BRANCH} \
    -m ${MANIFEST}

repo sync -j`nproc`

DISTRO=${DISTRO} MACHINE=${MACHINE} EULA=1 source ${SETUP} -b ${BUILDDIR} || exit $?

get_yocto_hash() {
    local githash=$(git rev-parse --short=10 HEAD)
    echo "$githash"
}

cd ${BASE_WORK_DIR}/sources/meta-nxp-mr
yocto_hash=$(get_yocto_hash)

RELEASE_VER="${BUILD_TYPE}-$(date +%y%m%d%H%M%S)-${yocto_hash}"

cd ${BASE_WORK_DIR}/${BUILDDIR}/conf
if ! grep -q 'PARALLEL_MAKE =' local.conf
then
cat >> local.conf <<EOF
PARALLEL_MAKE = "-j $(echo "$(nproc) / 4" | bc)"
EOF
fi
if ! grep -q 'BB_NUMBER_THREADS =' local.conf
then
cat >> local.conf <<EOF
BB_NUMBER_THREADS = "$(echo "$(nproc) / 2" | bc)"
EOF
fi
if ! grep -q 'KERNEL_LOCALVERSION =' local.conf
then
cat >> local.conf <<EOF
KERNEL_LOCALVERSION = "$RELEASE_VER"
EOF
fi

echo $RELEASE_VER > ${BASE_WORK_DIR}/sources/meta-nxp-mr/recipes-fsl/images/files/release || exit $?

cd ${BASE_WORK_DIR}
source sources/poky/oe-init-build-env ${BUILDDIR}
bitbake imx-image-ros

finish=`date +%s`; echo "### Build Time = `expr \( $finish - $start \) / 60` minutes"
