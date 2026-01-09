# Full ROS 2 image with navigation, camera, and application packages
# This layer changes frequently during active development

require imx-image-ros-msgs.bb

# NetworkManager gets installed as a dependency and tries to reload connections
# during postinst, which fails in the chroot without D-Bus. This is harmless.
# Downgrade log_check from ERROR to WARN to prevent build failure.
ERROR_QA:remove = "log_check"
WARN_QA:append = " log_check"

CUSTOM_FILES_PATH := "${THISDIR}/files"
SRC_URI = " \
    file://install_cognipilot.sh \
    file://release \
"

# ROS 2 camera and image processing packages
ROS_IMAGE_PACKAGES = " \
    ros-${ROS_VERSION}-camera-calibration \
    ros-${ROS_VERSION}-camera-calibration-parsers \
    ros-${ROS_VERSION}-camera-info-manager \
    ros-${ROS_VERSION}-compressed-image-transport \
    ros-${ROS_VERSION}-cv-bridge \
    ros-${ROS_VERSION}-gscam \
    ros-${ROS_VERSION}-image-pipeline \
    ros-${ROS_VERSION}-image-tools \
    ros-${ROS_VERSION}-image-transport \
    ros-${ROS_VERSION}-image-transport-plugins \
    ros-${ROS_VERSION}-v4l2-camera \
    ros-${ROS_VERSION}-vision-opencv \
"

# ROS 2 navigation packages
ROS_NAV_PACKAGES = " \
    ros-${ROS_VERSION}-nav2-bringup \
"

# ROS 2 CAN packages  
ROS_CAN_PACKAGES = " \
    ros-${ROS_VERSION}-dataspeed-can-msg-filters \
"

APTGET_EXTRA_PACKAGES_LAST += " \
    ${ROS_IMAGE_PACKAGES} \
    ${ROS_NAV_PACKAGES} \
    ${ROS_CAN_PACKAGES} \
"

ROOTFS_POSTPROCESS_COMMAND += "do_install_home_files;"

fakeroot do_install_home_files() {
    install -m 0755 ${CUSTOM_FILES_PATH}/install_cognipilot.sh ${APTGET_CHROOT_DIR}/home/user
    install -m 0644 ${CUSTOM_FILES_PATH}/release ${IMAGE_ROOTFS}${sysconfdir}/
    chmod 755 ${APTGET_CHROOT_DIR}/home/user/install_cognipilot.sh
}
