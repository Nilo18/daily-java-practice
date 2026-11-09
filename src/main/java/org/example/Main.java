package org.example;

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

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        synchronized (lock) {
//            Thread.sleep(1000);
            lock.wait(1000);
        }
        System.out.println("Hello world");
    }
}