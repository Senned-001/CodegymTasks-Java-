package com.codegym.task.task04.task0434;


/* 
Multiplication table

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int i=1,j=1;
        while (i <= 10) {
            while (j <= 10) {
                System.out.print(j*i + " ");j++;}
            System.out.println();
            i++;j=1;
        }

    }
}
