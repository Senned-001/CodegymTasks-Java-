package com.codegym.task.task07.task0723;


/* 
Countdown

*/

public class Solution {
    public static void main(String[] args) throws InterruptedException{
        for (int i = 30; i >= 0; i--) {
            System.out.println(i);
            Thread.sleep(100); //taimer obyazatelen throws InterruptedException v main
        }
        System.out.println("Boom!");
    }
}
