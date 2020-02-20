package com.codegym.task.task25.task2502;

import java.util.*;

/* 
Don't take the car to the shop!

*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            // Init wheels here
            if(loadWheelNamesFromDB()==null||loadWheelNamesFromDB().length>4) throw new IllegalArgumentException();
            wheels = new ArrayList<>();
            wheels.add(Wheel.valueOf(loadWheelNamesFromDB()[0]));
            wheels.add(Wheel.valueOf(loadWheelNamesFromDB()[1]));
            wheels.add(Wheel.valueOf(loadWheelNamesFromDB()[2]));
            wheels.add(Wheel.valueOf(loadWheelNamesFromDB()[3]));
        }


        protected String[] loadWheelNamesFromDB() {
            // This method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        System.out.println(Wheel.values()[1]);
    }
}
