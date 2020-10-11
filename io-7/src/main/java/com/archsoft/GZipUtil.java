package com.archsoft;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class GZipUtil {

    private GZipUtil() { }

    public static void zip(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[512];
        int off = 0;
        int len = buf.length;

        try(GZIPOutputStream gzip = new GZIPOutputStream(out)) {
            while ((len = in.read(buf, off, len)) != -1) {
                gzip.write(buf, off, len);
            }
        } finally {
            out.close();
        }
    }

    public static void unzip(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[512];
        int off = 0;
        int len = buf.length;

        try(GZIPInputStream gzip = new GZIPInputStream(in)) {
            while ((len = gzip.read(buf, off, len)) != -1) {
                out.write(buf, off, len);
            }
        } finally {
            out.close();
        }
    }
}
