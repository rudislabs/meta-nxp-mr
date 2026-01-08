FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# i.MX95 NavQ specific patches and configuration
SRC_URI:append:imx95-navq = " \
	file://0001-i.MX95-Uboot-SPL-Relocate-to-DDR.patch \
"

ERROR_QA:remove:imx95-navq = "patch-status"

do_configure[mcdepends] += "${@'mc:imx95-navqdesktop:imx95-navq-m7:zephyr-mcuboot:do_deploy' if d.getVar('MACHINE').startswith('imx95-navq') else ''}"

do_configure:append:imx95-navq () {
	cp ${TOPDIR}/tmp/m7_mcuboot_image.bin ${S}/iMX95/m7_mcuboot_image.bin
	sed -i 's/m7_image.bin/m7_mcuboot_image.bin/' ${WORKDIR}/git/iMX95/soc.mak
}
