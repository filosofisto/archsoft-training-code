package com.archsoft;

public class Statistic {

    public int max(int[] values) {
        int maxValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
            }
        }

        return maxValue;
    }

    public short max(short[] values) {
        short maxValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
            }
        }

        return maxValue;
    }

    public byte max(byte[] values) {
        byte maxValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
            }
        }

        return maxValue;
    }

    public long max(long[] values) {
        long maxValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
            }
        }

        return maxValue;
    }

    public float max(float[] values) {
        float maxValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
            }
        }

        return maxValue;
    }

    public double max(double[] values) {
        double maxValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
            }
        }

        return maxValue;
    }

    public int min(int[] values) {
        int minValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] < minValue) {
                minValue = values[i];
            }
        }

        return minValue;
    }

    public short min(short[] values) {
        short minValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] < minValue) {
                minValue = values[i];
            }
        }

        return minValue;
    }

    public long min(long[] values) {
        long minValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] < minValue) {
                minValue = values[i];
            }
        }

        return minValue;
    }

    public byte min(byte[] values) {
        byte minValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] < minValue) {
                minValue = values[i];
            }
        }

        return minValue;
    }

    public float min(float[] values) {
        float minValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] < minValue) {
                minValue = values[i];
            }
        }

        return minValue;
    }

    public double min(double[] values) {
        double minValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] < minValue) {
                minValue = values[i];
            }
        }

        return minValue;
    }
}
