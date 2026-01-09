# A more complex image with ROS elements
require imx-image-mr.bb

CUSTOM_FILES_PATH := "${THISDIR}/files"
SRC_URI = " \
    file://install_cognipilot.sh \
    file://release \
"

IMAGE_INSTALL += "\
    install-interface-config \
"

ROS_VERSION = "jazzy"
APTGET_ROS_APT_SOURCE = "noble"

# Build tools and utilities
BUILD_TOOLS = " \
    autoconf \
    automake \
    bc \
    binutils \
    bison \
    build-essential \
    bzip2 \
    ca-certificates \
    ccache \
    cmake \
    cppcheck \
    dirmngr \
    doxygen \
    file \
    flex \
    g++ \
    gcc \
    gdb \
    genromfs \
    git \
    gosu \
    gperf \
    lcov \
    libtool \
    make \
    ninja-build \
    pkg-config \
    protobuf-compiler \
    rsync \
    screen \
    shellcheck \
    tzdata \
    uncrustify \
    unzip \
    xsltproc \
    zip \
"

# Development libraries
DEV_LIBRARIES = " \
    libeigen3-dev \
    libfreetype6-dev \
    libgtest-dev \
    libimage-exiftool-perl \
    libncurses-dev \
    libopencv-dev \
    libpng-dev \
    libssl-dev \
    libxml2-utils \
    libyaml-cpp-dev \
"

# Python packages
PYTHON_PACKAGES = " \
    python3-argcomplete \
    python3-can \
    python3-cerberus \
    python3-colcon-common-extensions \
    python3-coverage \
    python3-dev \
    python3-empy \
    python3-flake8 \
    python3-hid \
    python3-ipython \
    python3-jinja2 \
    python3-matplotlib \
    python3-netifaces \
    python3-numpy \
    python3-opencv \
    python3-packaging \
    python3-pkgconfig \
    python3-psutil \
    python3-pysolar \
    python3-pytest-cov \
    python3-requests \
    python3-rosdep \
    python3-serial \
    python3-setuptools \
    python3-six \
    python3-testresources \
    python3-toml \
    python3-vcstool \
    python3-wheel \
"

# Networking and system utilities
SYSTEM_UTILS = " \
    can-utils \
    htop \
    iperf \
    iw \
    mesa-utils \
    nethogs \
    openssh-client \
    usbutils \
    v4l-utils \
    valgrind \
    vim-common \
"

# GStreamer packages
GSTREAMER_PACKAGES = " \
    gstreamer1.0-nice \
    gstreamer1.0-opencv \
"

# ROS 2 message packages (beyond ros-base which includes common-interfaces,
# tf2-*, rosgraph-msgs, lifecycle-msgs, action-msgs, statistics-msgs, unique-identifier-msgs)
ROS_MSG_PACKAGES = " \
    ros-${ROS_VERSION}-ackermann-msgs \
    ros-${ROS_VERSION}-actuator-msgs \
    ros-${ROS_VERSION}-apriltag-msgs \
    ros-${ROS_VERSION}-aruco-msgs \
    ros-${ROS_VERSION}-aruco-opencv-msgs \
    ros-${ROS_VERSION}-can-msgs \
    ros-${ROS_VERSION}-cartographer-ros-msgs \
    ros-${ROS_VERSION}-controller-manager-msgs \
    ros-${ROS_VERSION}-control-msgs \
    ros-${ROS_VERSION}-dwb-msgs \
    ros-${ROS_VERSION}-event-camera-msgs \
    ros-${ROS_VERSION}-foxglove-msgs \
    ros-${ROS_VERSION}-gazebo-msgs \
    ros-${ROS_VERSION}-geographic-msgs \
    ros-${ROS_VERSION}-gps-msgs \
    ros-${ROS_VERSION}-graph-msgs \
    ros-${ROS_VERSION}-grid-map-msgs \
    ros-${ROS_VERSION}-irobot-create-msgs \
    ros-${ROS_VERSION}-map-msgs \
    ros-${ROS_VERSION}-nav-2d-msgs \
    ros-${ROS_VERSION}-nav2-msgs \
    ros-${ROS_VERSION}-nmea-msgs \
    ros-${ROS_VERSION}-object-recognition-msgs \
    ros-${ROS_VERSION}-octomap-msgs \
    ros-${ROS_VERSION}-ouster-sensor-msgs \
    ros-${ROS_VERSION}-pcl-msgs \
    ros-${ROS_VERSION}-pendulum-msgs \
    ros-${ROS_VERSION}-plotjuggler-msgs \
    ros-${ROS_VERSION}-point-cloud-msg-wrapper \
    ros-${ROS_VERSION}-polygon-msgs \
    ros-${ROS_VERSION}-radar-msgs \
    ros-${ROS_VERSION}-rclpy-message-converter-msgs \
    ros-${ROS_VERSION}-robot-calibration-msgs \
    ros-${ROS_VERSION}-rosapi-msgs \
    ros-${ROS_VERSION}-rosbridge-msgs \
    ros-${ROS_VERSION}-rosbridge-test-msgs \
    ros-${ROS_VERSION}-rtcm-msgs \
    ros-${ROS_VERSION}-rviz-2d-overlay-msgs \
    ros-${ROS_VERSION}-system-modes-msgs \
    ros-${ROS_VERSION}-teleop-tools-msgs \
    ros-${ROS_VERSION}-test-msgs \
    ros-${ROS_VERSION}-twist-mux-msgs \
    ros-${ROS_VERSION}-ublox-msgs \
    ros-${ROS_VERSION}-ublox-ubx-msgs \
    ros-${ROS_VERSION}-udp-msgs \
    ros-${ROS_VERSION}-vision-msgs \
    ros-${ROS_VERSION}-vision-msgs-layers \
"

# ROS 2 core and tools (ros-base includes rmw, rmw-dds-common,
# rmw-implementation, rmw-implementation-cmake, launch-testing-ament-cmake)
ROS_CORE_PACKAGES = " \
    ros-${ROS_VERSION}-ros-base \
    ros-${ROS_VERSION}-rmw-cyclonedds-cpp \
    ros-${ROS_VERSION}-rmw-zenoh-cpp \
    ros-${ROS_VERSION}-topic-tools \
    ros-dev-tools \
"

# ROS 2 image/camera packages
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

# ROS 2 navigation
ROS_NAV_PACKAGES = " \
    ros-${ROS_VERSION}-nav2-bringup \
"

# ROS 2 CAN packages
ROS_CAN_PACKAGES = " \
    ros-${ROS_VERSION}-dataspeed-can-msg-filters \
"

# ROS 2 Qt-based packages (pulls in Qt5 dependencies)
# Uncomment if you need rqt tools or rviz plugins
# ROS_QT_PACKAGES = " \
#     ros-${ROS_VERSION}-rqt-msg \
#     ros-${ROS_VERSION}-vision-msgs-rviz-plugins \
# "

ROS_PACKAGES = " \
    ${BUILD_TOOLS} \
    ${DEV_LIBRARIES} \
    ${PYTHON_PACKAGES} \
    ${SYSTEM_UTILS} \
    ${GSTREAMER_PACKAGES} \
    ${ROS_CORE_PACKAGES} \
    ${ROS_MSG_PACKAGES} \
    ${ROS_IMAGE_PACKAGES} \
    ${ROS_NAV_PACKAGES} \
    ${ROS_CAN_PACKAGES} \
"

PYTHON_ROSDEP_PACKAGE = "${@bb.utils.contains('ROS_VERSION', 'jazzy', 'python3-rosdep', 'python3-rosdep', d)}"

ADD_ROS_PACKAGES ?= "${ROS_PACKAGES}"
APTGET_EXTRA_PACKAGES_LAST += " \
    ${ADD_ROS_PACKAGES} \
"

ROOTFS_POSTPROCESS_COMMAND += "do_install_home_files;"

fakeroot do_install_home_files() {
    install -m 0755 ${CUSTOM_FILES_PATH}/install_cognipilot.sh ${APTGET_CHROOT_DIR}/home/user
    install -m 0644 ${CUSTOM_FILES_PATH}/release ${IMAGE_ROOTFS}${sysconfdir}/
    chmod 755 ${APTGET_CHROOT_DIR}/home/user/install_cognipilot.sh
}

# Install WiFi configuration after rootfs is built to avoid NetworkManager reload errors
ROOTFS_POSTPROCESS_COMMAND += "install_wifi_config;"

install_wifi_config() {
\t# Install NetworkManager config to disable WiFi by default
\t# This is done in postprocess to avoid triggering NetworkManager during apt install
\tinstall -d ${IMAGE_ROOTFS}/etc/NetworkManager/conf.d
\tcat > ${IMAGE_ROOTFS}/etc/NetworkManager/conf.d/99-wifi-unmanaged.conf << 'EOFWIFI'
# NetworkManager config to not manage WiFi interfaces by default
# This prevents auto-scanning on boot
# To enable WiFi: sudo nmcli dev set mlan0 managed yes
[device-wifi-unmanaged]
match-device=interface-name:mlan0;interface-name:uap0;interface-name:wfd0
managed=0
EOFWIFI
\tchmod 0644 ${IMAGE_ROOTFS}/etc/NetworkManager/conf.d/99-wifi-unmanaged.conf
}
