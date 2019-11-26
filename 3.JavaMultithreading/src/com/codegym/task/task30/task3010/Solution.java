package com.codegym.task.task30.task3010;

/* 
Smallest possible radix

*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        //write your code here
        try {
            String start=args[0];
            if((start.matches("(.*)[^\\w](.*)"))||start.contains("_")) {    //if not digit or letter and not "_"
                System.out.println("Invalid");
            }
            else {
                int a;
                if(start.matches("(.*)[^\\d](.*)")){            //if consist letters
                    char[] mas=start.toUpperCase().toCharArray();
                    Arrays.sort(mas);
                    a=mas[mas.length-1]-64+10;                          //look a ASCII-table
                }
                else{                                               //if consist only digits
                    char[] mas=start.toCharArray();
                    Arrays.sort(mas);
                    a=mas[mas.length-1]-47;
                }
                if(a==1)a++;            //for double system
                System.out.println(a);
            }
        } catch (Exception e) {

        }
    }
}