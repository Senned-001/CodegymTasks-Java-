package com.codegym.task.task14.task1408;

/* 
Chicken factory

*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Continent.AFRICA);
        hen.getMonthlyEggCount();
        System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String continent) {
            Hen hen = null;
            if(continent.equals("Europe")) hen = new EuropeanHen();
            else if (continent.equals("North America")) hen = new NorthAmericanHen();
            else if (continent.equals("Asia")) hen = new AsianHen();
            else if (continent.equals("Africa")) hen = new AfricanHen();
            return hen;
        }
    }








}
