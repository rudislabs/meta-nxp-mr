DESCRIPTION = "Configure network interfaces on NavQPlus and NavQ95"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Ethernet via netplan, CAN via systemd-networkd (netplan doesn't support CAN)
# WiFi config is installed via image postprocess to avoid NetworkManager reload during build
SRC_URI:imx8mpnavq = " \
	file://10-ethernet.yaml \
	file://10-can.network \
"

SRC_URI:imx95-navq = " \
	file://10-ethernet-navq95.yaml \
	file://10-can.network \
"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

do_install() {
	# Install netplan config for ethernet
	install -d ${D}/etc/netplan
	install -m 0600 ${S}/*.yaml ${D}/etc/netplan/

	# Install systemd-networkd config for CAN (netplan doesn't support CAN)
	install -d ${D}/etc/systemd/network
	install -m 0644 ${S}/10-can.network ${D}/etc/systemd/network/

	# NOTE: WiFi config (99-wifi-unmanaged.conf) is installed by the image recipe
	# via ROOTFS_POSTPROCESS_COMMAND to avoid triggering NetworkManager during build
}

FILES:${PN} = "/etc/netplan /etc/systemd/network"
