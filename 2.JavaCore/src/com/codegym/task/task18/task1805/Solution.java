package com.codegym.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Sorting bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(name);


        Set<Integer> t = new HashSet();

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read(); //прочитать очередной байт
            t.add(data);
        }
        inputStream.close(); //

        ArrayList<Integer>s=new ArrayList<>(t);
        Collections.sort(s);


        for(int i=0;i<s.size();i++){
          System.out.print(s.get(i)+" ");

        }




    }
}
