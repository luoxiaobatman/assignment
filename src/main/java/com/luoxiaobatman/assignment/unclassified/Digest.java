package com.luoxiaobatman.assignment.unclassified;


import java.io.IOException;
import java.util.zip.CRC32;

public class Digest {
    public static void main(String[] args) throws IOException {
        CRC32 crc32 = new CRC32();
        crc32.update(123124);
        System.out.println(crc32);
    }
}
