package com.archsoft;

public class GStatistic {

    public <T extends Number> T max(T[] values) {
        T maxValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i].doubleValue() > maxValue.doubleValue()) {
                maxValue = values[i];
            }
        }

        return maxValue;
    }

    public <T extends Number> T min(T[] values) {
        T minValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i].doubleValue() < minValue.doubleValue()) {
                minValue = values[i];
            }
        }

        return minValue;
    }
}
