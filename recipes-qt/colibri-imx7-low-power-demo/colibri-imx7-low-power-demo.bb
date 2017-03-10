SUMMARY = "Colibri iMX7 Low Power Demo"
DESCRIPTION = "Colibri iMX7 Low Power Demo for Embedded World"
HOMEPAGE = "www.toradex.com"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "qtcharts qtserialport"

SRCREV = "60cb0c801b15b4e9ee37cd63e36ff22de015cbbd"
SRC_URI = "git://github.com/SanchayanMaity/EmbeddedWorldLowPowerDemo.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit qmake5

