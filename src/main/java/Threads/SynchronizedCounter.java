package Threads;

public class SynchronizedCounter {
    private int a = 0;

    public synchronized void increament() {
        a++;
    }

    public synchronized void decreament() {
        a--;
    }

    public synchronized int getValue() {
        return a;
    }
}
