package com.pxd.javacoursecodes.w2.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServerTest {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8801);

        while (true){
            try {
                Socket socket = serverSocket.accept();
                service(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void service(Socket socket) {

        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello,nio1";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();

            printWriter.write(body);
            printWriter.close();

            //这里主要是为了让httpClient可以在server的socket关闭前，拿到返回的结果
            Thread.sleep(10);

            socket.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
