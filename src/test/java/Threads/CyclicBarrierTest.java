package Threads;

import org.junit.Test;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CyclicBarrierTest {

    @Test
    public void testCyclicBarrier() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Runnable> workers = Stream.generate(() -> new Worker(cyclicBarrier)).limit(10)
                .collect(Collectors.toList());
        if (!cyclicBarrier.isBroken()) {
            service.submit(workers.get(0));
            Thread.sleep(1000);

            service.submit(workers.get(1));
            Thread.sleep(1000);

            service.submit(workers.get(2));
            Thread.sleep(1000);

            service.submit(workers.get(3));
            Thread.sleep(1000);

            service.submit(workers.get(4));
            Thread.sleep(1000);

            service.submit(workers.get(5));
            Thread.sleep(1000);

            service.submit(workers.get(6));
            Thread.sleep(1000);

            service.submit(workers.get(7));
            Thread.sleep(1000);

            service.submit(workers.get(8));
            Thread.sleep(1000);

            service.submit(workers.get(9));
            Thread.sleep(1000);
        }
    }

    class Worker implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public Worker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override public void run() {
            try {
                System.out
                        .println(Thread.currentThread().getName() + " is waiting for CyclicBarrier at " + Instant.now()
                                .toEpochMilli());
                cyclicBarrier.await();
                System.out.println(
                        Thread.currentThread().getName() + " is doing its job at " + Instant.now().toEpochMilli());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}