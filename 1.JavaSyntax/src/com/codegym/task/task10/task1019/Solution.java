package com.codegym.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
/* 
Functionality is not enough!

*/

public class Solution {
    public static void main(String[] args) throws IOException, NullPointerException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        while(true){
            int v=0;
            String k = reader.readLine();
            if(!k.equals(""))
                v = Integer.parseInt(k);
            else
                break;
            k = reader.readLine();
            if(k.equals(""))
                {map.put("",v);break;}
            else
                map.put(k,v);
        }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            String t = pair.getKey();
            int a = pair.getValue();
            System.out.println(a + " " + t);
        }
        reader.close();
    }
}
