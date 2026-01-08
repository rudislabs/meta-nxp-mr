FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Default u-boot branch for i.MX95 NavQ
SRCBRANCH = "imx95-navq-lf-6.12.y"

# NavQPlus (i.MX8MP) uses its own u-boot branch
SRCBRANCH:imx8mpnavq = "imx8mp-navq-lf-6.12.y"

# NavQPlus uses rudislabs fork
UBOOT_SRC:imx8mpnavq = "git://github.com/rudislabs/uboot-imx.git;protocol=https;branch=${SRCBRANCH}"

# NavQ95 uses NXP-Robotics private repo
UBOOT_SRC = "git://git@github.com/NXP-Robotics/uboot-imx-private.git;protocol=ssh;branch=${SRCBRANCH}"
SRCREV = "${AUTOREV}"

SRC_URI:append:imx95-navq = " file://${TARGET_NAME}.cfg"
