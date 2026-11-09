package org.example.concurrency.waitnotify;

public class MessageBox {
    // Both synchronized methods use this box's monitor to guard the message slot.
    private String message;

    public synchronized void produce(String text) {
        message = text;
        // Signal waiting consumers after storing the message so they can recheck the slot.
        notifyAll();
    }

    public synchronized String consume() throws InterruptedException {
        // Recheck the slot after every wakeup because it may still be empty.
        while (message == null) {
            // Release the monitor so the producer can enter, then reacquire it before returning.
            wait(1000);
        }

        // Empty the slot so a later call waits for a new message.
        String result = message;
        message = null;
        return result;
    }
}
