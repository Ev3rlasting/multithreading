package Futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class FutureExamples {

    public CompletableFuture<String> createCompletableFuture() {
        final CompletableFuture<String> completableFuture = new CompletableFuture<String>();
        Executors.newCachedThreadPool().submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completableFuture.complete("Completed!!");
            return;
        });
        return completableFuture;
    }

    public CompletableFuture<String> createCompletableFutureWithCancelledTask() {
        final CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(5000);
            completableFuture.cancel(false);
            return null;
        });
        return completableFuture;
    }
}
