package com.codegym.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Introducing properties

*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception{
        // Implement this method
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        reader.close();

        InputStream inputStream = new FileInputStream(name1);
        //OutputStream outputStream = new FileOutputStream(name1);

        load(inputStream);
        //save(outputStream);

        inputStream.close();
        //outputStream.close();



    }

    public void save(OutputStream outputStream) throws Exception {
        // Implement this method
        PrintWriter writer = new PrintWriter(outputStream);
        Properties prop = new Properties();



        for(Map.Entry<String, String> x : properties.entrySet()){
            prop.put(x.getKey(),x.getValue());
        }
        prop.store(outputStream, null);
        writer.flush();
        writer.close();

    }

    public void load(InputStream inputStream) throws Exception {
        // Implement this method


        Properties prop = new Properties();
        prop.load(inputStream);
        for (String key : prop.stringPropertyNames())
        {
            properties.put(key,prop.getProperty(key));
        }
        prop.clear();
    }

    public static void main(String[] args) {

    }
}
