DESCRIPTION = "Configure network interfaces on NavQPlus and NavQ95"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Ethernet via netplan, CAN via systemd-networkd (netplan doesn't support CAN)
# WiFi disabled by default via NetworkManager config
SRC_URI:imx8mpnavq = " \
	file://10-ethernet.yaml \
	file://10-can.network \
	file://99-wifi-unmanaged.conf \
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

	# Install NetworkManager config to disable WiFi by default (if present)
	if [ -f ${S}/99-wifi-unmanaged.conf ]; then
		install -d ${D}/etc/NetworkManager/conf.d
		install -m 0644 ${S}/99-wifi-unmanaged.conf ${D}/etc/NetworkManager/conf.d/
	fi
}

FILES:${PN} = "/etc/netplan /etc/systemd/network /etc/NetworkManager"
