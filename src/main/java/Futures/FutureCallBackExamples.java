package Futures;

import java.util.concurrent.*;

public class FutureCallBackExamples {

    private Callable<String> callableTask = () -> {
        Thread.sleep(500);
        return "CallBackTask done";
    };

    private ExecutorService exe = Executors.newCachedThreadPool();

    public void callBack() throws InterruptedException, ExecutionException {
        Future f1 = exe.submit(callableTask);
        Future f2 = exe.submit(callableTask);
        Future f3 = exe.submit(callableTask);
        Future f4 = exe.submit(callableTask);

        exe.shutdown();
        exe.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());

        System.out.println(f1.get());
    }

}
