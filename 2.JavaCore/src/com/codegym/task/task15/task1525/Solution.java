package com.codegym.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
File in a static block

*/

public class Solution {
    public static List<String> lines = new ArrayList<>();



    static{
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME));

            String line = reader.readLine();
            while (line != null){
                lines.add(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
