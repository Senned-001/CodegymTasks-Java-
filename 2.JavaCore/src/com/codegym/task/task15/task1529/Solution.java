package com.codegym.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Mastering the static block

*/

public class Solution {
    public static void main(String[] args) {
    }
    
    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1="";
        try {
            name1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(name1.equals("helicopter")) result = new Helicopter();
        else if (name1.equals("plane")){
            int i=0;
            try {
                i = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = new Plane(i);
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
