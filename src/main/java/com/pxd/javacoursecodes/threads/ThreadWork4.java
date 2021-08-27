package com.pxd.javacoursecodes.threads;

/**
 * 主线程sleep 500ms，肯定可以等来结果
 */
public class ThreadWork4 {

    static volatile Integer result;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> result = getResult());

        t1.start();

        Thread.sleep(500);

        System.out.println(result);
    }

    private static int getResult() {
        return 11;
    }

}
