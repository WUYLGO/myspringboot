package com.wyl.research.util;

public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton doubleCheckSingleton;

    public static DoubleCheckSingleton getInstance() {
        if (doubleCheckSingleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (doubleCheckSingleton == null) {
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }
        return doubleCheckSingleton;

    }

}
