package com.codegym.task.task34.task3411;

/* 
Tower of Hanoi

*/

public class Solution {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        //write your code here
        if(numRings>0){
            moveRing(a,c,b,numRings-1);
            System.out.println("from "+a+" to "+b);
            moveRing(c,b,a,numRings-1);
        }
    }
}