package com.codegym.task.task18.task1822;

/* 
Finding data inside a file

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        reader.close();

        BufferedReader r = new BufferedReader(new FileReader(file1));
        String id=args[0];
        String data=r.readLine();
        while (data!=null){
            if(data.split(" ")[0].equals(id)) System.out.println(data);
            data=r.readLine();
        }
        r.close();
    }
}
