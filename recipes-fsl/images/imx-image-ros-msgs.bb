# ROS 2 message packages layer
# Changes when adding new message types for sensors/actuators

require imx-image-ros-core.bb

# ROS 2 message packages (grows as new hardware is added)
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

APTGET_EXTRA_PACKAGES_LAST += " \
    ${ROS_MSG_PACKAGES} \
"
