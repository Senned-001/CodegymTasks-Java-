package com.codegym.task.task09.task0918;

/* 
We're all friends here, even the exceptions

*/

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends RuntimeException{
    }

    static class MyException2 extends MyException{
    }

    static class MyException3 extends Exception{
    }

    static class MyException4 extends MyException3{
    }
}

