package com.pxd.javacoursecodes.threads;

import java.util.concurrent.locks.LockSupport;

/**
 *  用LockSupport的park和unpark来实现
 */
public class ThreadWork11 {

    static volatile Integer result;

    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();

        Thread t1 = new Thread(() -> {
            result = getResult();
            LockSupport.unpark(mainThread);
        });
        t1.start();

        LockSupport.park();

        System.out.println(result);
    }

    private static int getResult() {
        return 11;
    }
}
