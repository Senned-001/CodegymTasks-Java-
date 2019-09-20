package com.codegym.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Different methods for different types

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String name = reader.readLine();
            if(name.equals("exit")){
                reader.close();break;
            }
            boolean doub, inte;
            Double d=0.0;
            int i=0;
            {//proverka convertacii double i int
                try {
                    d = Double.parseDouble(name);
                    doub=true;
                } catch (NumberFormatException e) {
                    doub=false;
                }
                try {
                    i = Integer.parseInt(name);
                    inte = true;
                } catch (NumberFormatException e) {
                    inte = false;
                }

            }

                if(name.contains(".")&&doub) {
                    print(d);
                }
                else if (inte&&(i>0)&&(i<128)){

                    print((short)i);
                }
                else if (inte){
                    print(i);
                }
                else print(name);

        }
    }

    public static void print(Double value) {
        System.out.println("This is a Double. Value: " + value);
    }

    public static void print(String value) {
        System.out.println("This is a String. Value: " + value);
    }

    public static void print(short value) {
        System.out.println("This is a short. Value: " + value);
    }

    public static void print(Integer value) {
        System.out.println("This is an Integer. Value: " + value);
    }
}
