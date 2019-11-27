package com.codegym.task.task30.task3012;

/* 
Derive a specific number

*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //write your code here
        StringBuilder result = new StringBuilder().append(number).append(" =");
        String [] formats = {""," + %d"," - %d"};
        for (int i = number, tri = 1; 0 < i; i = ++i / 3, tri *= 3) {
            result.append(String.format(formats[i%3],tri));
        }
        System.out.println(result);
    }
}