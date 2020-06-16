package com.nio.simple;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * bio
 */
public class BioTest {

    public void process() throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress("localhost",9090));

        while (true){
            Socket client = server.accept();
            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while(true){
                String s = reader.readLine();
                if(null !=s){
                    System.out.printf(s);
                }else{
                    break;
                }
            }
            System.out.printf("连接断开");

        }


    }

    public static void main(String[] args) throws IOException {
        BioTest bioTest = new BioTest();
        bioTest.process();
    }
}
