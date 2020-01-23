package com.codegym.task.task40.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/* 
Sending a GET request via a socket

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://codegym.cc/social.html"));
    }

    public static void getSite(URL url) {

        String hostName = url.getHost();
        try {
            Socket socket = new Socket(hostName,80);
            OutputStream os = socket.getOutputStream();
            PrintWriter out = new PrintWriter(os, true);
            out.println("GET " + url.getFile());
            out.println("Host: " + hostName);
            out.print("User-Agent: Mozilla/5.0");
            out.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String responseLine;
            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            out.close();
            os.close();
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}