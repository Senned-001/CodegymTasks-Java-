package com.codegym.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Threads and bytes

*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String name = reader.readLine();
            if(name.equals("exit")) break;
            else resultMap.put(name,0);
        }

        reader.close();
        for(HashMap.Entry<String, Integer> x : resultMap.entrySet()){
            new ReadThread(x.getKey()).start();
        }
    }

    public static class ReadThread extends Thread {
        private String filename;
        public ReadThread(String fileName) {
            // Implement constructor body
            this.filename=fileName;
        }
        // Implement file reading here
        @Override
        public void run() {
            int key= 0;
            try {
                FileInputStream inputStream = new FileInputStream(filename);
                HashMap<Integer,Integer> t = new HashMap<>();
                int max =0;
                while (inputStream.available() > 0) //пока остались непрочитанные байты
                {
                    int data = inputStream.read(); //прочитать очередной байт
                    if(t.containsKey(data))
                        t.replace(data,t.get(data)+1);
                    else
                        t.put(data,1);
                    if(t.get(data)>max) {
                        max=t.get(data); //srazu schitaem max povtoreniy
                        key=data;
                    }
                }
                inputStream.close(); // закрываем поток
            } catch (IOException e) {
                e.printStackTrace();
            }
            resultMap.replace(filename,key);
        }
    }
}
