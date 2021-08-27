package com.pxd.javacoursecodes.threads;

import java.util.concurrent.*;

/**
 * 使用ExcuterService来启动线程,用Callable来代替Runnable,并且获取到future里的返回值
 */
public class ThreadWork6 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = new ThreadPoolExecutor(1,
                1,
                5L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        Future future = executorService.submit(new ThreadCallBack());

        System.out.println(future.get());

        executorService.shutdown();
    }

    private static int getResult() {
        return 11;
    }

    static class ThreadCallBack implements Callable<Integer>{

        @Override
        public Integer call() {
            return getResult();
        }
    }

}
