package com.codegym.task.task19.task1920;

/* 
The richest

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read1f = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map=new TreeMap<>();
        double maxval=0;
        String data ="";
        while((data=read1f.readLine())!=null){
            if(map.containsKey(data.split(" ")[0])) {
                map.put(data.split(" ")[0], map.get(data.split(" ")[0]) + Double.parseDouble(data.split(" ")[1]));
                if(map.get(data.split(" ")[0])>maxval)
                    maxval = map.get(data.split(" ")[0]);
            }
            else {
                map.put(data.split(" ")[0],Double.parseDouble(data.split(" ")[1]));
                if(map.get(data.split(" ")[0])>maxval)
                    maxval = map.get(data.split(" ")[0]);
            }
        }
        read1f.close();

        for(Map.Entry<String, Double> x : map.entrySet()){
            if(x.getValue()==maxval)
            System.out.println(x.getKey());
        }
    }
}
