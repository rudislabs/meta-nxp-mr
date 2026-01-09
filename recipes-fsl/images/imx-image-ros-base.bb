# Base image with Ubuntu, kernel, drivers, and firmware
# This layer rarely changes - only on BSP or kernel updates

require imx-image-mr.bb

IMAGE_INSTALL += "\
	install-interface-config \
"

# Basic apt packages needed by higher layers
APTGET_EXTRA_PACKAGES += "\
	ntpdate patchelf \
"
