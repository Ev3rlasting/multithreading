package Threads;

import org.junit.Test;

public class SimpleThreadTest {

    @Test
    public void testSimpleThread() throws InterruptedException {
        SimpleThread simpleThread1 = new SimpleThread("Simple Thread1");
        SimpleThread simpleThread2 = new SimpleThread("Simple Thread2");
        SimpleThread simpleThread3 = new SimpleThread("Simple Thread3");
        simpleThread1.starter();
        simpleThread2.starter();
        simpleThread3.starter();
        Thread.sleep(5000);
    }
}