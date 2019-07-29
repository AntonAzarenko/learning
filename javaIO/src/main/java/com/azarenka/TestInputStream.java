package com.azarenka;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class TestInputStream {

    public static void main(String[] args) throws IOException {
        InputStream url = new URL("https://www.google.com/").openStream();
        char[] bytes = readByByte(url);
    }

    private static char[] readByByte(InputStream stream) throws IOException {
        char[] bytes = new char[5000];
        int oneByte;
        while ((oneByte = stream.read()) != -1) {
            int count = 0;
            bytes[count++] = (char) oneByte;

        }
        return bytes;
    }
}
