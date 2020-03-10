package com.codegym.task.task34.task3403;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Factorization using recursion

*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse(132);
    }

    public void recurse(int n) {

        if(n<=1)return;
        if(n>1){
            if(n%2==0) {
                System.out.print(2+" ");
                recurse(n/2);
            }
            else if(n%3==0) {
                System.out.print(3+" ");
                recurse(n/3);
            }
            else if(n%5==0) {
                System.out.print(5+" ");
                recurse(n/5);
            }
            else if(n%7==0) {
                System.out.print(7+" ");
                recurse(n/7);
            }
            else {

                System.out.print(n+" ");
            }
        }
    }
}