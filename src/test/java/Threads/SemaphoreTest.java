package Threads;

import org.junit.Test;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SemaphoreTest {

    @Test
    public void semaphoreBasicTest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(3);
        List<Worker> workers = Stream.generate(() -> new Worker(semaphore)).limit(10).collect(Collectors.toList());
        workers.forEach(w -> {
            executorService.submit(w);

        });
        executorService.shutdown();
        executorService.awaitTermination(2000, TimeUnit.SECONDS);
        

    }

    class Worker implements Runnable {
        private Semaphore semaphore;

        public Worker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " is acquiring Semaphore at "
                        + Instant.now().toEpochMilli());
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " is doing its job at "
                        + Instant.now().toEpochMilli());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " is releaseing Semaphore at "
                        + Instant.now().toEpochMilli());
            }

        }
    }
}
