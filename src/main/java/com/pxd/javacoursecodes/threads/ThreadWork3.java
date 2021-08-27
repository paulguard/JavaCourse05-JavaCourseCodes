package com.pxd.javacoursecodes.threads;

/**
 * 使用join，确保t1结束之后，主线程才继续运行
 */
public class ThreadWork3 {

    static volatile Integer result;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> result = getResult());

        t1.start();
        t1.join();

        System.out.println(result);
    }

    private static int getResult() {
        return 11;
    }

}
