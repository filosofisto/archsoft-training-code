package com.archsoft.util;

import java.util.concurrent.TimeUnit;

public class Util {

    public static void waitFor(int seconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
