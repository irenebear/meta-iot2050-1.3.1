SUMMARY = "Open source implementation of OPC UA"
HOMEPAGE = "https://open62541.org/"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRC_URI = "git://github.com/open62541/open62541.git"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"

do_install() {
    install -d ${D}${libdir}
    install -m 0644 ${B}/bin/libopen62541.so ${D}${libdir}
    install -d ${D}${includedir}
    cp -R ${S}/include/* ${D}${includedir}
}

FILES_${PN} += "${libdir}/libopen62541.so"
FILES_${PN}-dev += "${includedir}/*"
