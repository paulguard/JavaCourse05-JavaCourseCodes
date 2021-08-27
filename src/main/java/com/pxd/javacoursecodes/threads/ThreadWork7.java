package com.pxd.javacoursecodes.threads;

import java.util.concurrent.*;

/**
 * 用CountDownLatch来实现
 */
public class ThreadWork7 {

    static Integer result;

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
            result = getResult();
            countDownLatch.countDown();
        });
        t1.start();

        countDownLatch.await();

        System.out.println(result);
    }

    private static int getResult() {
        return 11;
    }
}
