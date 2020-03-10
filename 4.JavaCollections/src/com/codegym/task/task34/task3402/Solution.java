package com.codegym.task.task34.task3402;

/* 
Factorials using recursion

*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.factorial(9));     // 362880
        System.out.println(solution.factorial(0));     // 1
        System.out.println(solution.factorial(1));     // 1
    }

    public int factorial(int n) {
        int result=1;
        if(n==0||n==1) return result;
        for(int i=2;i<=n;i++){
            result=factorial(i-1)*i;
        }
        return result;
    }
}