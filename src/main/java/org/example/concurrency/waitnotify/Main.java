package org.example.concurrency.waitnotify;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MessageBox box = new MessageBox();

        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Waiting for a message...");
                String message = box.consume();
                System.out.println("Received: " + message);
            } catch (InterruptedException e) {
                // Restore the interrupt flag before the worker exits.
                Thread.currentThread().interrupt();
            }
        });

        Thread producer = new Thread(() -> {
            try {
                // Give the consumer time to reach the wait before publishing.
                Thread.sleep(1000);
                box.produce("Hello from producer!");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        consumer.start();
        producer.start();

        // Keep the main thread here until both workers finish.
        consumer.join();
        producer.join();
    }
}
