SUMMARY = "Colibri iMX7 Low Power Demo"
DESCRIPTION = "Colibri iMX7 Low Power Demo for Embedded World"
HOMEPAGE = "www.toradex.com"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "qtcharts qtserialport"

SRCREV = "82f6ed0f7abf43e8a1ee018f0d736c49afe34684"
SRC_URI = "git://github.com/SanchayanMaity/EmbeddedWorldLowPowerDemo.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit qmake5

