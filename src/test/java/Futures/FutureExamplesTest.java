package Futures;

import org.junit.Test;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FutureExamplesTest {

    @Test
    public void testAsync() throws InterruptedException, ExecutionException {
        FutureExamples futureExamples = new FutureExamples();
        Future<String> future = futureExamples.createCompletableFuture();
        System.out.println("You could do something else here...");
        Thread.sleep(5000);
        System.out.println("Main Thread 5000ms gone..");
        String result = future.get();
        System.out.println(result);
    }

    @Test
    public void testAsync2() throws InterruptedException, ExecutionException {
        FutureExamples futureExamples = new FutureExamples();

        Future<String> future = futureExamples.createCompletableFuture();
        while (!future.isDone()) {
            System.out.println("not completed!");
            Thread.sleep(100);
        }
        System.out.println("completed.");
        System.out.println(future.get());
    }

    @Test(expected = CancellationException.class)
    public void testCancelInAsync() throws InterruptedException, ExecutionException {
        FutureExamples futureExamples = new FutureExamples();
        Future<String> future = futureExamples.createCompletableFuture();
        for (int i = 0; i < 5; i++) {
            System.out.println("not completed!");
            Thread.sleep(500);
        }
        future.cancel(true);
        while (!future.isDone()) {
            System.out.println("not completed!");
            Thread.sleep(100);
        }
        System.out.println(future.get());
    }

    @Test
    public void testCancel() throws InterruptedException, ExecutionException {
        FutureExamples futureExamples = new FutureExamples();
        Future<String> future = futureExamples.createCompletableFutureWithCancelledTask();
        try {
            String result = future.get();
            System.out.println(result);
        } catch (CancellationException e) {
            System.out.println("This Future is cancelled.");
            e.printStackTrace();
        }
    }
}