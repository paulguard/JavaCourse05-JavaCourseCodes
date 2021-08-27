package com.pxd.javacoursecodes.threads;

/**
 * 用while来等待result被赋值
 */
public class ThreadWork1 {

    static Integer result;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> result = getResult());

        t1.start();

        while (result == null){
        }

        System.out.println(result);
    }

    private static int getResult() {
        return 11;
    }


}
