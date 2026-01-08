# Patch 0001-Modify-regular-expression-pattern-for-kernels-filter.patch
# was merged upstream in tensorflow-imx lf-6.12.49_2.2.0 branch

do_install:append () {
	install -d ${D}/usr/local/lib/python3.12/dist-packages
	mv ${D}/${PYTHON_SITEPACKAGES_DIR}/* ${D}/usr/local/lib/python3.12/dist-packages
	rm -rf ${D}/${PYTHON_SITEPACKAGES_DIR}
}

FILES:${PN} += "/usr/local/lib/python3.12/*"

ERROR_QA:remove = "libdir patch-status"
