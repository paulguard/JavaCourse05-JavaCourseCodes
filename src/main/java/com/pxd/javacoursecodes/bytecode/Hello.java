package com.pxd.javacoursecodes.bytecode;

public class Hello {

    public static void main(String[] args) {

        int num1 = 1;
        int num2 = 2;

        for (int i=0;i<4;i++){
            num1 = ((num1 + num2) * 4)/2;
            if (num1 >=15) {
                break;
            }
        }

    }

}
