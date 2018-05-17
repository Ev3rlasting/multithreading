package Futures;

import com.google.common.base.Stopwatch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureExamples {

    private static ExecutorService exe = Executors.newFixedThreadPool(10);
    private static final List<String> TOP_SITES = Arrays.asList(
            "www.google.com", "www.youtube.com", "www.yahoo.com", "www.msn.com",
            "www.wikipedia.org", "www.baidu.com", "www.microsoft.com", "www.qq.com",
            "www.bing.com", "www.ask.com", "www.adobe.com", "www.taobao.com",
            "www.youku.com", "www.soso.com", "www.wordpress.com", "www.sohu.com",
            "www.windows.com", "www.163.com", "www.tudou.com", "www.amazon.com"
    );

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

    public void websiteCrawlerWithFixedThreadPool() throws IOException {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("executorServiceResult.log"))) {
            List<Future<String>> contentsFuture = new ArrayList<>(TOP_SITES.size());
            Stopwatch stopwatch = Stopwatch.createStarted();
            TOP_SITES.forEach(s -> {
                final Future<String> f = executorService.submit(() -> {
                    try {
                        Thread.sleep(1000);
                        return null;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
                contentsFuture.add(f);
            });
            contentsFuture.forEach(f -> {
                try {
                    f.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
            stopwatch.stop();
            System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
            executorService.shutdownNow();
        }
    }

    public void websiteCrawlerWithCompletionExecutorService()
            throws InterruptedException, ExecutionException, IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("executorCompletionServiceResult.log"))) {
            final ExecutorService executorService = Executors.newFixedThreadPool(10);
            ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
            Stopwatch stopwatch = Stopwatch.createStarted();
            TOP_SITES.forEach(s ->
                    completionService.submit(() -> {
                        Thread.sleep(1000);
                        return null;
                    })
            );
            for (int i = 0; i < TOP_SITES.size(); i++) {
                try {
                    completionService.take().get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
            stopwatch.stop();
            System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
            executorService.shutdownNow();
        }

    }
}