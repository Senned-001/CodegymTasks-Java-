package com.codegym.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Method in a try-catch

*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> a = new ArrayList<>();
        try {
            while(true){
                a.add(Integer.parseInt(reader.readLine()));
            }
        }
        catch (Exception e) {
                //e.printStackTrace();
                for(Integer x:a) {
                    System.out.println(x);
                }
        }
    }
}
