package Futures;

import org.junit.Test;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FutureExamplesTest {
    private static FutureExamples futureExamples = new FutureExamples();

    @Test
    public void testAsync() throws InterruptedException, ExecutionException {
        Future<String> future = futureExamples.createCompletableFuture();
        System.out.println("You could do something else here...");
        Thread.sleep(5000);
        System.out.println("Main Thread 5000ms gone..");
        String result = future.get();
        System.out.println(result);
    }

    @Test
    public void testAsync2() throws InterruptedException, ExecutionException {
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
        Future<String> future = futureExamples.createCompletableFutureWithCancelledTask();
        try {
            String result = future.get();
            System.out.println(result);
        } catch (CancellationException e) {
            System.out.println("This Future is cancelled.");
            e.printStackTrace();
        }
    }

    @Test
    public void testNonBlockingFuture() throws ExecutionException, InterruptedException {
        System.out.println(futureExamples.nonBlockingFuture().get());
    }

    @Test
    public void supplyAsyncTest() throws ExecutionException, InterruptedException {
        System.out.println(futureExamples.supplyAsync().get());
    }

    @Test
    public void thenApplyTest() throws ExecutionException, InterruptedException {
        System.out.println(futureExamples.thenApplyExample().get());
    }

    @Test
    public void thenRunTest() throws ExecutionException, InterruptedException {
        futureExamples.thenRunExample().get();
    }

    @Test
    public void thenComposeTest() throws ExecutionException, InterruptedException {
        System.out.println(futureExamples.thenComposeExample().get());
    }
    
    @Test
    public void thenCombineTest() throws ExecutionException, InterruptedException {
        System.out.println(futureExamples.thenCombineExample().get());
    }

}