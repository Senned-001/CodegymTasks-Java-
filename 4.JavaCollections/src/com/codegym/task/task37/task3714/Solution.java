package com.codegym.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/* 
Ancient Rome

*/
public class Solution {
    public static HashMap<Character,Integer> table=new HashMap<>();
    static {
        table.put('I',1);
        table.put('V',5);
        table.put('X',10);
        table.put('L',50);
        table.put('C',100);
        table.put('D',500);
        table.put('M',1000);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman numeral to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result: " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        char[] number = s.toCharArray();
        int result=0;
        for(int i=0;i<number.length;i++){
            if(table.containsKey(number[i])){
                if(i>0) {
                    if(table.get(number[i])>table.get(number[i-1])) {       //compare this elem with previous
                        result=result+(table.get(number[i])-table.get(number[i-1])*2);  //if this plus - then reduce
                        continue;
                    }

                }
                result+=table.get(number[i]);

            }
        }
        return result;
    }



}
