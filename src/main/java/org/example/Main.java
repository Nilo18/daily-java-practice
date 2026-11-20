package org.example;

import java.util.Arrays;

enum Operation {
    ADD {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },

    MULTIPLY {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    };

    public abstract int apply(int a, int b);
}

public class Main {
    public static int finallyReturn() {
        int x = 1;

        try {
            return x;
        } finally {
            x = 2;
            System.out.println("Finally block is running and it changed x: " + x);
        }
    }

    public static void changePrimitive(double value) {
        value = Math.random();
    }

    public static void test() {
        try {
            throw new IllegalStateException("Original");
        } finally {
            throw new RuntimeException("Cleanup failed");
        }
    }

    public static void changeObject(A a) {
        a.value = 3;
    }

    public static Runnable task() {
        return () -> System.out.println("Hello");
    }

    public static void varargsMethod(int... args) {
        System.out.println(Arrays.toString(args));
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable a = task();
        Runnable b = task();

        IO.println(a == b);
        int[] arr = {1, 2, 3};
        varargsMethod(arr);
        varargsMethod(1, 2, 3);
    }
}