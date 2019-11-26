package com.codegym.task.task30.task3002;

/* 
Mastering the methods of the Integer class

*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); // 22
        System.out.println(convertToDecimalSystem("012"));  // 10
        System.out.println(convertToDecimalSystem("0b10")); // 2
        System.out.println(convertToDecimalSystem("62"));   // 62
    }

    public static String convertToDecimalSystem(String s) {
        //write your code here
        int a=0;
        if(s.startsWith("0x")){
            a=Integer.parseInt(s.substring(2),16);
        }
        else if(s.startsWith("0b")){
            a=Integer.parseInt(s.substring(2),2);
        }
        else if(s.startsWith("0")){
            a=Integer.parseInt(s.substring(1),8);
        }
        else {
            a=Integer.parseInt(s);
        }

        return Integer.toString(a,10);
    }
}
