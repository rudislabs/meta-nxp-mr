# Base image with Ubuntu, kernel, drivers, and firmware
# This layer rarely changes - only on BSP or kernel updates

PV = "${@d.getVar('PREFERRED_VERSION_ubuntu-base', True) or '1.0'}"

require fsl-image-common.inc

# Foundation packages - these rarely change
IMAGE_INSTALL += "\
	ubuntu-base \
	ubuntu-base-dev \
	ubuntu-base-dbg \
	ubuntu-base-doc \
"

# Kernel and drivers
IMAGE_INSTALL += "\
	kernel-dev \
	kernel-devsrc \
	kernel-modules \
"

# Hardware support
IMAGE_INSTALL += "\
	firmwared \
	udev-extraconf \
	packagegroup-fsl-gstreamer1.0-full \
	install-interface-config \
"

# i.MX8MP specific packages
IMAGE_INSTALL:append:imx8mpnavq = " \
	libopenvx-imx \
	libopenvx-imx-dev \
	libnn-imx \
	tensorflow-lite \
	tensorflow-lite-vx-delegate \
"

# i.MX95 specific packages
IMAGE_INSTALL:append:imx95-navq = " \
	rpmsgexport \
	rpmsgfs-remotedirs \
"

# Basic apt packages needed by higher layers
APTGET_EXTRA_PACKAGES += "\
	ntpdate patchelf \
"
