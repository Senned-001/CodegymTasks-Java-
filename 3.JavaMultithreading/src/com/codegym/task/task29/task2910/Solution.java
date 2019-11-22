package com.codegym.task.task29.task2910;

/* 
The archaic word "biathlon"

*/

public class Solution {

    public static void main(String[] args) {
        Competition competition = new Competition();
        printDelimiter();
        competition.start();
        System.out.println("\n\nALL RESULTS:");
        competition.printAllResults();
        printDelimiter();
        System.out.println("\n\nATHLETES WITH THE SAME TOTAL TIME AS THE CONTROL ATHLETE :");
        competition.printAthletesWithSameTime();
        printDelimiter();

    }

    private static void printDelimiter() {
        System.out.println("=================================================================================================");
    }
}