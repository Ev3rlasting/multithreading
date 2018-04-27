package Threads;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServicesTest {

    private Runnable printingTask(int threadId) {
        return () -> {
            int i = 10;
            while (i-- > 0) {
                System.out.println("This Thread: " + threadId + " working on printing " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private Runnable writeCollectionsTask(Map map) {
        return () -> {
            String uuid = UUID.randomUUID().toString();
            for (int i = 0; i < 10000; i++) {
                if (map instanceof ConcurrentMap) {
                    ((ConcurrentHashMap)map).put("key" + uuid + i, i);
                }
                if (map instanceof HashMap) {
                    ((HashMap)map).put("key" + uuid + i, i);
                }
            }
        };
    }

    @Test
    public void testCacheThreadPool() throws InterruptedException {
        ExecutorService exe = Executors.newCachedThreadPool();
        exe.submit(printingTask(1));
        exe.submit(printingTask(2));
        exe.submit(printingTask(3));
        Thread.sleep(5000);
    }

    @Test
    public void testMapWithoutShutDown() throws InterruptedException {
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        HashMap<String, Integer> hashMap = new HashMap();
        ExecutorService exe = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exe.submit(writeCollectionsTask(concurrentMap));
            exe.submit(writeCollectionsTask(hashMap));
        }
        System.out.println("ConcurrentMap: " + concurrentMap.size());
        System.out.println("HashMap: " + hashMap.size());
    }

    @Test
    public void testMapWithShutDown() throws InterruptedException {
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        HashMap<String, Integer> hashMap = new HashMap();
        ExecutorService exe = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exe.submit(writeCollectionsTask(concurrentMap));
            exe.submit(writeCollectionsTask(hashMap));
        }
        // Add shutdown
        exe.shutdown();
        exe.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        System.out.println("ConcurrentMap: " + concurrentMap.size());
        System.out.println("HashMap: " + hashMap.size());
    }

    @Test
    public void testMapWithAtomicInteger() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService exe = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            exe.submit(() -> {
                for (int j = 0; j < 10000; j++)
                    atomicInteger.getAndIncrement();
            });
        }
        exe.shutdown();
        exe.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("AtomicInteger: " + atomicInteger);
    }

}
