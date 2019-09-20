package com.codegym.task.task03.task0303;

/* 
Currency exchange

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(20,1.5));
        System.out.println(convertEurToUsd(25,1.8));
    }

    public static double convertEurToUsd(int eur, double exchangeRate) {
        double usd;
        return usd = eur*exchangeRate;
    }
}
