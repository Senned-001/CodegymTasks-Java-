package com.codegym.task.task13.task1326;

/* 
Sorting even numbers from a file

*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine();
        reader.close();

        FileInputStream inStream = new FileInputStream(fname);
        BufferedReader br = new BufferedReader(new InputStreamReader(inStream));

        String s;
        ArrayList<Integer> list=new ArrayList<>();
        while((s=br.readLine())!=null){
            if(Integer.parseInt(s)%2==0)
                list.add(Integer.parseInt(s));
        }
        Collections.sort(list);
        inStream.close();
        br.close();
        for (Integer x:list) {
            System.out.println(x);
        }
    }
}
