package Futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureExamples {

    private static ExecutorService exe = Executors.newCachedThreadPool();

    public CompletableFuture<String> createCompletableFuture() {
        final CompletableFuture<String> completableFuture = new CompletableFuture<String>();
        exe.submit(() -> {
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
        exe.submit(() -> {
            Thread.sleep(5000);
            completableFuture.cancel(false);
            return null;
        });
        return completableFuture;
    }

    public CompletableFuture<String> nonBlockingFuture() {
        final CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Instant Complete.");
        return completableFuture;
    }

    public CompletableFuture<String> supplyAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                return "Completed!";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }, exe);
    }

    public CompletableFuture<String> thenApplyExample() {
        return CompletableFuture.supplyAsync(() -> "first part completed", exe)
                .thenApply(s -> s + " thenApplyExample completed");
    }

    public CompletableFuture<Void> thenRunExample() {
        final CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Instant Complete.");
        return completableFuture
                .thenRun(() -> System.out.println("thenRun finished."));
    }

    public CompletableFuture<String> thenComposeExample() {
        return CompletableFuture
                .supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"))
                .thenApply(s -> s + "!!!");
    }

    public CompletableFuture<String> thenCombineExample() {
        return CompletableFuture
                .supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(() -> "World")
                        , (s1, s2) -> s1 + s2)
                .thenCombine(CompletableFuture.supplyAsync(() -> "!!!!")
                        , (s1, s2) -> s1 + s2);
    }
}
