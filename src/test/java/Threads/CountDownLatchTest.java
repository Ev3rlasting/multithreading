package Threads;

import org.junit.Test;

import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    @Test
    public void testCountDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new Worker(countDownLatch));
        Thread.sleep(1000);

        executorService.submit(new Worker(countDownLatch));
        Thread.sleep(1000);

        executorService.submit(new Worker(countDownLatch));
        Thread.sleep(1000);
        
        countDownLatch.countDown();
    }

    class Worker implements Runnable {

        private CountDownLatch triggerEventCountDownLatch;

        public Worker(CountDownLatch triggerEventCountDownLatch) {
            this.triggerEventCountDownLatch = triggerEventCountDownLatch;
        }

        @Override public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting CountDownLatch "
                        + Instant.now().toEpochMilli());
                triggerEventCountDownLatch.await();
                System.out.println(Thread.currentThread().getName() + " is doing its job at "
                        + Instant.now().toEpochMilli());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
