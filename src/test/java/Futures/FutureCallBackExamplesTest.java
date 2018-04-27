package Futures;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class FutureCallBackExamplesTest {
    private FutureCallBackExamples futureCallBackExamples = new FutureCallBackExamples();

    @Test
    public void test() throws InterruptedException, ExecutionException {
        futureCallBackExamples.callBack();
    }

}