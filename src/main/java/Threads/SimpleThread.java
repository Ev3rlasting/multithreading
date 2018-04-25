package Threads;

public class SimpleThread implements Runnable {

    private Thread thread;
    private String threadName;

    public SimpleThread(String name) {
        this.threadName = name;
    }

    public void run() {
        int i = 5;
        try {
            while (--i > 0) {
                System.out.println("Thread: " + threadName + " is working on something.");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread: " + threadName + " is interrupted.");
            e.printStackTrace();
        }
        System.out.println("Thread: " + threadName + " exiting.");

    }

    public void starter() {
        System.out.println("Starting Thread: " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
        }
        thread.start();
    }
}
