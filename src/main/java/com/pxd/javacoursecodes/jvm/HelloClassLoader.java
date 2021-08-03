package com.pxd.javacoursecodes.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {

        try {
            Object hello = new HelloClassLoader().findClass("src/main/java/com/pxd/javacoursecodes/jvm/Hello.xlass", "Hello").newInstance();
            Method helloMethod = hello.getClass().getDeclaredMethod("hello");
            helloMethod.invoke(hello,null);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    protected Class<?> findClass(String filePath,String className){

        File file = new File(filePath);
        FileInputStream inputFileStream = null;
        byte[] buffer = new byte[0];
        try {
            inputFileStream = new FileInputStream(file);
            buffer = new byte[(int)file.length()];

            inputFileStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Objects.nonNull(inputFileStream)) {
                    inputFileStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        decode(buffer);

        return defineClass(className, buffer, 0, buffer.length);
    }

    private void decode(byte[] buffer) {

        byte temp;
        for (int i = 0; i < buffer.length; i++) {
            temp = buffer[i];
            buffer[i] = (byte) (~temp);
        }
    }

}
