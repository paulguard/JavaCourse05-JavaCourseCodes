package com.pxd.javacoursecodes.threads;

/**
 * 用runnable来代替直接new线程，为了不凑数量，这个runnable就写一次
 */
public class ThreadWork2 {

    static volatile Integer result;

    public static void main(String[] args) {

        Runnable runnable = () -> result = getResult();

        Thread t1 = new Thread(runnable);
        t1.start();

        while (result == null){
        }

        System.out.println(result);
    }

    private static int getResult() {
        return 11;
    }


}
