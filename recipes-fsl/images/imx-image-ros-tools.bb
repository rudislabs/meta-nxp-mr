# Development tools and libraries layer
# Changes occasionally when adding new development dependencies

require imx-image-ros-base.bb

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
    python3-numpy \
    python3-pil \
    python3-pip \
"

# System utilities
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

# Networking stack
NETWORK_PACKAGES = " \
    kmod \
    console-setup \
    locales \
    apt \
    vim \
    ethtool \
    wget \
    ftp \
    iputils-ping \
    net-tools \
    libtool \
    autoconf \
    pkg-config \
    bluez \
    python-is-python3 \
    netplan.io \
"

APTGET_EXTRA_PACKAGES_LAST += " \
    ${BUILD_TOOLS} \
    ${DEV_LIBRARIES} \
    ${PYTHON_PACKAGES} \
    ${SYSTEM_UTILS} \
    ${GSTREAMER_PACKAGES} \
    ${NETWORK_PACKAGES} \
"
