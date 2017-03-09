SUMMARY = "Toradex Embedded Linux Qt5 Demo With X11"

# after the boot systemd starts X and then a qt5 application
# check recipes-qt/qt5/qt5-x11-free-systemd.bb for the systemd service
# responsible for this

LICENSE = "MIT"

PV = "V2.7"

#start of the resulting deployable tarball name
IMAGE_NAME_colibri-imx7 = "Colibri_iMX7_LowPowerDemo-qt5"
IMAGE_NAME = "${MACHINE}_LinuxImage-qt5"

SYSTEMD_DEFAULT_TARGET = "graphical.target"

#create the deployment directory-tree
require recipes-images/images/trdx-image-fstype.inc

inherit populate_sdk_qt5

IMAGE_LINGUAS = "en-us"
#IMAGE_LINGUAS = "de-de fr-fr en-gb en-us pt-br es-es kn-in ml-in ta-in"
#ROOTFS_POSTPROCESS_COMMAND += 'install_linguas; '

DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

CONMANPKGS ?= "connman connman-systemd connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi connman-client"
CONMANPKGS_libc-uclibc = ""

DEPENDS += "gst-plugins-good gst-plugins-bad gst-plugins-ugly"

GSTREAMER = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-base-alsa \
    gstreamer1.0-plugins-base-audioconvert \
    gstreamer1.0-plugins-base-audioresample \
    gstreamer1.0-plugins-base-audiotestsrc \
    gstreamer1.0-plugins-base-typefindfunctions \
    gstreamer1.0-plugins-base-ivorbisdec \
    gstreamer1.0-plugins-base-ogg \
    gstreamer1.0-plugins-base-theora \
    gstreamer1.0-plugins-base-videotestsrc \
    gstreamer1.0-plugins-base-vorbis \
    gstreamer1.0-plugins-good-audioparsers \
    gstreamer1.0-plugins-good-autodetect \
    gstreamer1.0-plugins-good-avi \
    gstreamer1.0-plugins-good-deinterlace \
    gstreamer1.0-plugins-good-id3demux \
    gstreamer1.0-plugins-good-isomp4 \
    gstreamer1.0-plugins-good-matroska \
    gstreamer1.0-plugins-good-rtp \
    gstreamer1.0-plugins-good-rtpmanager \
    gstreamer1.0-plugins-good-udp \
    gstreamer1.0-plugins-good-video4linux2 \
    gstreamer1.0-plugins-good-wavenc \
    gstreamer1.0-plugins-good-wavparse \
"
GSTREAMER_append_mx6 = " \
    gstreamer1.0-plugins-base-ximagesink \
    gstreamer1.0-plugins-imx \
    imx-gst1.0-plugin \
    imx-gst1.0-plugin-gplay \
    imx-gst1.0-plugin-grecorder \
"
GSTREAMER_append_mx7 = " \
    gstreamer1.0-plugins-base-ximagesink \
    imx-gst1.0-plugin \
"
IMAGE_INSTALL_QT5 = " \
    packagegroup-qt5 \
    liberation-fonts \
    colibri-imx7-low-power-demo \
    qt5-x11-free-lpd-systemd \
"

IMAGE_INSTALL_append_mx6 = " \
    packagegroup-fsl-gpu-libs \
    libopencl-mx6 \
    eglinfo-x11 \
"

# Packages which might no longer exist
RRECOMMENDS_${PN} += "xserver-xorg-multimedia-modules"

IMAGE_INSTALL += " \
    ${IMAGE_INSTALL_QT5} \
    \
    xdg-utils \
    \
    libgsf \
    libxres \
    makedevs \
    mime-support \
    xcursor-transparent-theme \
    zeroconf \
    angstrom-packagegroup-boot \
    packagegroup-basic \
    udev-extra-rules \
    ${CONMANPKGS} \
    ${ROOTFS_PKGMANAGE_PKGS} \
    timestamp-service \
    packagegroup-base-extended \
    ${XSERVER} \
    xserver-common \
    xserver-xorg-extension-dbe \
    xserver-xorg-extension-extmod \
    xauth \
    xhost \
    xset \
    setxkbmap \
    \
    xrdb \
    xorg-minimal-fonts xserver-xorg-utils \
    scrot \
    unclutter \
    \
    libxdamage libxvmc libxinerama \
    libxcursor \
    \
    bash \
    \
    ${GSTREAMER} \
    v4l-utils \
    libpcre \
    libpcreposix \
    libxcomposite \
    alsa-states \
    \
    emmy-w1-driver-sdiosdio \
    linux-firmware-sd8887 \
"

require recipes-images/images/trdx-extra.inc

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"

export IMAGE_BASENAME = "qt5-lpd-image"

inherit core-image
