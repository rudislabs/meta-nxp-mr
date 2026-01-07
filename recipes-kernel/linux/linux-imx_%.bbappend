FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
         file://cpufreq.cfg \
         file://usbserial.cfg \
         file://fs_sec.cfg \
"

SRC_URI:append:imx95-navq = " \
         file://rpmsg.cfg \
         file://mali.cfg \
         file://input.cfg \
         file://video-dummy.cfg \
         file://panel-ili9881c.cfg \
         file://cam.cfg \
"

### NavQPlus patches now applied in rudislabs/linux-imx imx8mp-navq-lf-6.12.y branch:
### - 0001-net-phy-nxp-c45-tja11xx-add-rev-rmii-support.patch
### - 0002-net-fec-add-rev-rmii-support.patch
### - 0003-arm64-dts-imx8mp-navq-Fix-TJA1103-phy.patch
### UWB patches (0004, 0005) and OV5645 camera (0006) skipped for now

# Default kernel branch for i.MX95 NavQ
SRCBRANCH = "imx95-navq-lf-6.12.y"

# NavQPlus (i.MX8MP) uses its own kernel branch with NavQPlus-specific patches
SRCBRANCH:imx8mpnavq = "imx8mp-navq-lf-6.12.y"

SRCREV = "${AUTOREV}"
# NavQPlus uses rudislabs fork with NavQPlus-specific patches
LINUX_IMX_SRC:imx8mpnavq = "git://github.com/rudislabs/linux-imx.git;protocol=https;branch=${SRCBRANCH}"

# NavQ95 uses NXP-Robotics private repo
LINUX_IMX_SRC = "git://git@github.com/NXP-Robotics/linux-imx-private.git;protocol=ssh;branch=${SRCBRANCH}"
SRC_URI = "${LINUX_IMX_SRC}"

do_configure:append () {
    ${S}/scripts/kconfig/merge_config.sh -m -O ${B} ${B}/.config $(ls ${UNPACKDIR}/*.cfg)

    if [ ! -z "${LOCALVERSION}" ]; then
        echo "CONFIG_LOCALVERSION=\"\"" >> ${B}/.config
    fi
}

