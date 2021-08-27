package com.pxd.javacoursecodes.threads;

import java.util.concurrent.Semaphore;

/**
 * 用Semaphore来实现
 */
public class ThreadWork8 {

    static Integer result;

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1);

        semaphore.acquire();

        Thread t1 = new Thread(() -> {
            result = getResult();
            semaphore.release();
        });
        t1.start();

        while (semaphore.availablePermits() == 0) {
        }

        System.out.println(result);
    }

    private static int getResult() {
        return 11;
    }
}
