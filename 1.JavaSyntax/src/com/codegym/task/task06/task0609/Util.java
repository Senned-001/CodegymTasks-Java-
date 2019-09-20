package com.codegym.task.task06.task0609;

/* 
Distance between two points

*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        double dis = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        return dis;
    }

    public static void main(String[] args) {

    }
}
