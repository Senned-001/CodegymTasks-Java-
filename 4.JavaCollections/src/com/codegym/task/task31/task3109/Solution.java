package com.codegym.task.task31.task3109;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Reading config files

*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/codegym/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/codegym/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/codegym/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName)    {
        Path file= Paths.get(fileName);
        Properties prop=new Properties();
        if(fileName.substring(fileName.lastIndexOf(".")+1,fileName.length()).equalsIgnoreCase("xml")){
            try {
                prop.loadFromXML(Files.newInputStream(file));
                } catch (IOException e) {
                return prop;
            }
        }
        else{
            try {
                prop.load(Files.newInputStream(file));

            } catch (IOException e) {
                return prop;
            }
        }
        return prop;
    }
}
