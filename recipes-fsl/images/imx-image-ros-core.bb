# ROS 2 core packages layer
# Changes when updating ROS core or middleware

require imx-image-ros-tools.bb

ROS_VERSION = "jazzy"
APTGET_ROS_APT_SOURCE = "noble"

# ROS 2 core packages (stable, rarely changes)
ROS_CORE_PACKAGES = " \
    ros-${ROS_VERSION}-ros-base \
    ros-${ROS_VERSION}-rmw-cyclonedds-cpp \
    ros-${ROS_VERSION}-rmw-zenoh-cpp \
    ros-${ROS_VERSION}-topic-tools \
    ros-dev-tools \
"

APTGET_EXTRA_PACKAGES_LAST += " \
    ${ROS_CORE_PACKAGES} \
"
