PACKAGECONFIG:remove = "${PACKAGECONFIG_REMOVALS}"
PACKAGECONFIG_REMOVALS               ?= ""
PACKAGECONFIG_REMOVALS:mx8mm-nxp-bsp ?= "vulkan"
