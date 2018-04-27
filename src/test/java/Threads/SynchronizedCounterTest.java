package Threads;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedCounterTest {

    @Test
    public void test() throws InterruptedException {
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        ExecutorService exe = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 10000; i++) {
            exe.submit(() -> {
                for (int j = 0; j < 10000; j++) {
                    synchronizedCounter.increament();
                }
            });
        }
        exe.shutdown();
        exe.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println(synchronizedCounter.getValue());
    }
}