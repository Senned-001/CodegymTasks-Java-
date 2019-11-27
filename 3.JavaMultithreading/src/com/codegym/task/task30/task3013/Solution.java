package com.codegym.task.task30.task3013;

/* 
Bit operations

*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        //write your code here
        number |= number >> 1;  //number=number|(number>>1)            >> have higher priority than |
        number |= number >> 2;
        number |= number >> 4;
        number |= number >> 8;
        number |= number >> 16; //0000011111111111...
        return number &= ~number >> 1;

    }
}