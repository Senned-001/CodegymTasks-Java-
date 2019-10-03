package com.codegym.task.task22.task2202;

/* 
Find a substring

*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("CodeGym is the best place"));
    }

    public static String getPartOfString(String string) {
        if(string==null) throw new StringTooShortException();
        int count=0;
        int ind=0;
        for(int i=0;i<string.length();i++){
            if(string.charAt(i)==' ') count++;
            if(count==5) {
                ind=i;
                break;
            }
        }
        if(count==4) ind=string.length();
        else if(count<4) throw new StringTooShortException();

        string = string.substring(string.indexOf(" ")+1,ind);
        return string;

    }

    public static class StringTooShortException extends RuntimeException {
    }
}