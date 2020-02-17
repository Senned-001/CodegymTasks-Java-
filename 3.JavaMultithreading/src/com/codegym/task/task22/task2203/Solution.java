package com.codegym.task.task22.task2203;

/* 
Between tabs

*/
public class Solution {
    public static String getPartOfString(String string) throws StringTooShortException {
        if(string==null)
            throw new StringTooShortException();
        try {
            string=string.substring(string.indexOf("\t")+1,string.length());
            string=string.substring(0,string.indexOf("\t"));
            return string;
        } catch (Exception e) {
            throw new StringTooShortException();
        }
    }

    public static class StringTooShortException extends Exception {
    }

    public static void main(String[] args) throws StringTooShortException {
        System.out.println(getPartOfString("\tCodeGym is the best place \tto learn Java\t."));
    }
}