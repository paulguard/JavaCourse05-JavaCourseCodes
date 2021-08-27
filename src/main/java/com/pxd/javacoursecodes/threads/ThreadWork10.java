package com.pxd.javacoursecodes.threads;

import java.util.Objects;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  用object的wait和 notify来实现（其实也可以用notifyAll，因为一共就一个线程）
 */
public class ThreadWork10 {

    static volatile Integer result;

    final static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            result = getResult();
            synchronized (object){
                object.notify();
            }
        });
        t1.start();

        synchronized (object){
            object.wait();
        }

        System.out.println(result);
    }

    private static int getResult() {
        return 11;
    }
}
