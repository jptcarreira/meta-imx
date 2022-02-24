# Copyright 2021 NXP
DESCRIPTION = "Tensorflow-lite-extras package"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "opencv tensorflow-lite flatbuffers python3 python3-pip python3-numpy"

EFFICIENTDET_SRC ?= "git://source.codeaurora.org/external/imx/efficientdet-imx.git;protocol=https"
SRCBRANCH = "master"

SRC_URI = "${EFFICIENTDET_SRC};branch=${SRCBRANCH}"
SRCREV = "45946df40048fc58517febda84ba92ff0df149f1"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile:prepend() {
    cd ${S}/efficientdet/src
}

do_install() {
    install -d ${D}${bindir}/${BPN}

    install -m 0755 ${S}/efficientdet/models/efficientdet-lite0/* ${D}${bindir}/${BPN}
    install -m 0755 ${S}/efficientdet/src/efficientdet_demo ${D}${bindir}/${BPN}
    install -m 0755 ${S}/samples/cars_short.mp4 ${D}${bindir}/${BPN}
    install -m 0755 ${S}/DEMO_README.md ${D}${bindir}/${BPN}
}

COMPATIBLE_MACHINE = "(mx8qm-nxp-bsp|mx8mp-nxp-bsp)"
