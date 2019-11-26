package com.codegym.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Palindrome?

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        // Expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        // Expected output: [6]
        System.out.println(getRadix("5321"));       // Expected output: []
        System.out.println(getRadix("1A"));         // Expected output: []
    }
    private static Set<Integer> getRadix(String number){
        Set<Integer>result=new HashSet<>();
        for (int i=2;i<37;i++){
            int a=0;
            try {
                a=Integer.parseInt(number);
            } catch (NumberFormatException e) {

            }
            String s=Integer.toString(a,i);
            //System.out.println("Number in "+i+" system:"+s);
            if(!s.equalsIgnoreCase("0")){
                if(s.length()%2==0){
                    String s1=s.substring(0,s.length()/2);
                    StringBuffer s2=new StringBuffer(s.substring(s.length()/2,s.length()));
                    s2.reverse();
                    //System.out.println("s1:"+s1+"   s2:"+s2.toString());
                    if(s1.equalsIgnoreCase(s2.toString())) result.add(i);
                }
                else{
                    String s1=s.substring(0,(s.length()-1)/2);
                    StringBuffer s2=new StringBuffer(s.substring((s.length()-1)/2+1,s.length()));
                    s2.reverse();
                    //System.out.println("s1:"+s1+"   s2:"+s2.toString());
                    if(s1.equalsIgnoreCase(s2.toString())) result.add(i);
                }
            }

        }
        return result;
    }
}