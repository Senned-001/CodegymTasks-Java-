package com.codegym.task.task35.task3501;
/* 
Calling a static method

*/
public class Solution {
    public static void main(String[] args) {
        Number number = StaticGeneric.<Number>someStaticMethod(new Integer(3));
    }
}