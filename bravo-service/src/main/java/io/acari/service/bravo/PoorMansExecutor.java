package io.acari.service.bravo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class PoorMansExecutor {

    @Async
    public <T> Future<T> submit(Callable<T> callable) throws Exception {
        return new AsyncResult<>(callable.call());
    }

    @Async
    public  void submit(Runnable runnable) {
        runnable.run();
    }
}
