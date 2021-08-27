package com.pxd.javacoursecodes.threads;

import java.util.concurrent.*;

/**
 * 使用ExcuterService来启动线程，然后用sleep阻塞
 */
public class ThreadWork5 {

    static volatile Integer result;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = new ThreadPoolExecutor(1,
                1,
                5L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        executorService.submit(() -> {
            result = getResult();
        });

        Thread.sleep(500);

        System.out.println(result);

        executorService.shutdown();
    }

    private static int getResult() {
        return 11;
    }

}
