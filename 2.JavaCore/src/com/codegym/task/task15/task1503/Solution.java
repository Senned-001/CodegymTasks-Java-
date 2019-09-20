package com.codegym.task.task15.task1503;

/* 
OOP: Cars

*/

public class Solution {
    public static void main(String[] args) {
        new Solution.LuxuryCar().printlnDesire();
        new Solution.CheapCar().printlnDesire();
        new Solution.Ferrari().printlnDesire();
        new Solution.GeoMetro().printlnDesire();
    }

    public static class LuxuryCar{
         void printlnDesire(){
            System.out.println(Constants.WANT_STRING+Constants.LUXURY_CAR);
        }
    }

    public static class CheapCar{
         void printlnDesire(){
            System.out.println(Constants.WANT_STRING+Constants.CHEAP_CAR);
        }
    }

    public static class Ferrari extends LuxuryCar{
        public void printlnDesire() {
            System.out.println(Constants.WANT_STRING+Constants.FERRARI_NAME);
        }
    }

    public static class GeoMetro extends CheapCar{
        public void printlnDesire() {
            System.out.println(Constants.WANT_STRING+Constants.GEO_METRO_NAME);
        }
    }




    public static class Constants {
        public static String WANT_STRING = "I want to drive ";
        public static String LUXURY_CAR = "a luxury car";
        public static String CHEAP_CAR = "a cheap car";
        public static String FERRARI_NAME = "a Ferrari";
        public static String GEO_METRO_NAME = "a Geo Metro";
    }
}
