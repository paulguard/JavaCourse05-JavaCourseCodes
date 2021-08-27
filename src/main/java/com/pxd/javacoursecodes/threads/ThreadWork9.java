package com.pxd.javacoursecodes.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 用CyclicBarrier来实现
 */
public class ThreadWork9 {

    static Integer result;

    static CyclicBarrier cyclicBarrier;

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        // 一个是t1，一个是主线程，2个线程都await才算是结束了
        cyclicBarrier = new CyclicBarrier(2);

        Thread t1 = new Thread(() -> {
            result = getResult();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t1.start();

        cyclicBarrier.await();

        System.out.println(result);
    }

    private static int getResult() {
        return 11;
    }
}
