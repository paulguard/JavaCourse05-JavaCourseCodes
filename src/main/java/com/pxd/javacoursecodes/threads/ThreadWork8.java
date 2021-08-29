package com.pxd.javacoursecodes.threads;

import java.util.concurrent.Semaphore;

/**
 * 用Semaphore来实现
 */
public class ThreadWork8 {

    static Integer result;

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(0);

        Thread t1 = new Thread(() -> {
            result = getResult();
            semaphore.release();
        });
        t1.start();

        semaphore.acquire();

        System.out.println(result);
    }

    private static int getResult() {
        return 11;
    }
}
