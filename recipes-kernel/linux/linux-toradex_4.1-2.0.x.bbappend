FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-4.1-2.0.x:"

SRC_URI += "file://0001-ARM-dts-imx7-colibri-introduce-low-power-carrier-boa.patch"

LOCALVERSION = "-v2.7lpd"
SRCREV = "c3fc0914d837d8243810f93f76a4816634546888"
SRCBRANCH = "toradex_4.1-2.0.x-imx-next"
