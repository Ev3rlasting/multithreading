package Futures;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleFuture {

    public Future<String> calculateAsync() throws InterruptedException {
        final CompletableFuture<String> completableFuture = new CompletableFuture<String>();
        Executors.newCachedThreadPool().submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completableFuture.complete("Completed");
            return;
        });
        return completableFuture;
    }

    @Test
    public void test() throws InterruptedException, ExecutionException {
        SimpleFuture simpleFuture = new SimpleFuture();
        Future<String> future = simpleFuture.calculateAsync();
        System.out.println("You could do something here...");
        Thread.sleep(5000);
        System.out.println("Main Thread 5000ms gone..");
        String result = future.get();
        System.out.println(result);
    }
}
