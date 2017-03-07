FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-4.1-2.0.x:"

SRC_URI += "file://0001-ARM-dts-imx7-colibri-introduce-low-power-carrier-boa.patch"

LOCALVERSION = "-v2.7lpd"
SRCREV = "5b7f11c074c9876958f0d092a7ce66ba11cd33f2"
SRCBRANCH = "toradex_4.1-2.0.x-imx-next"

KERNEL_MODULE_AUTOLOAD += " imx_rpmsg_tty"
