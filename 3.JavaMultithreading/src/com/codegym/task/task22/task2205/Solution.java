package com.codegym.task.task22.task2205;

/* 
I LOVE CodeGym!

*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), "CodeGym", "i", "love"));
        // The output should be
        // "I LOVE CodeGym!"
    }
    public static String getFormattedString() {
        return "%2$S %3$S %s!";
    }
}