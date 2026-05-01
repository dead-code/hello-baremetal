SUMMARY = "This is a BitBake recipe for a minimal bare-metal Hello World binary"
DESCRIPTION = "Builds a simple non-Linux firmware using ARM GCC"
LICENSE = "MIT"

# Where to fetch source code
SRC_URI = "https://github.com/dead-code/hello-baremetal.git"

# Directory where sources will be unpacked
S = "${WORKDIR}/git"

# Custom toolchain (non-Linux)
export CC = "arm-none-eabi-gcc"
export LD = "arm-none-eabi-ld"

# Define tasks
do_compile() {
    ${CC} -c ${S}/hello.c -o hello.o
    ${LD} hello.o -o hello.elf
}

do_install() {
    install -d ${D}/firmware
    install -m 0644 hello.elf ${D}/firmware/
}
