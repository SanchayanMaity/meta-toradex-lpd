FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-4.1-2.0.x:"

SRC_URI += "file://0001-ARM-dts-imx7-colibri-introduce-low-power-carrier-boa.patch"

LOCALVERSION = "-v2.7lpd"
SRCREV = "743acf373f90890f2c08b96f10a8436a6731023d"
SRCBRANCH = "toradex_4.1-2.0.x-imx-next"

KERNEL_MODULE_AUTOLOAD += " imx_rpmsg_tty"
