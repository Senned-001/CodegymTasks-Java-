package com.codegym.task.task04.task0433;


/* 
Seeing dollars in your future

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String s="$";
        int i=10,j=10;
        while (i > 0){
            while (j > 0){
                System.out.print(s);
                j--;
            }
            System.out.println();
            i--;
            j=10;
        }
    }
}
