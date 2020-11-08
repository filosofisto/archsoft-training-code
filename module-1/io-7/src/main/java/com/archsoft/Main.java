package com.archsoft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {
        try {
            File fin = new File("pom.xml");
            System.out.printf("Tamanho original: %d bytes\n", fin.length());

            File fout = new File("pom.xml.gzip");
            GZipUtil.zip(new FileInputStream(fin), new FileOutputStream(fout));
            System.out.printf("Tamanho compactado: %d bytes\n", fout.length());

            System.out.printf("Percentual Ganho: %.2f%%", 100-(fout.length() * 1.0 / fin.length() * 100));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
