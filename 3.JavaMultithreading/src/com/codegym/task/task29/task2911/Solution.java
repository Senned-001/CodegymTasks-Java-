package com.codegym.task.task29.task2911;

import java.util.Random;
import java.util.Scanner;

/* 
And more refactoring

*/

public class Solution {
    public static boolean playerWon = false;

    public static void main(String[] args) {
        new Solution().runGame();
    }

    private void runGame() {
        Random random = new Random();
        int secret = random.nextInt(1000);
        int tryNumber = -1;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Attempt %d - Guess a number: ", i);
            tryNumber = scanner.nextInt();
            if (tryNumber < secret)
                if (i < 10)
                    System.out.println("The secret number is bigger");
            if (tryNumber > secret)
                if (i < 10)
                    System.out.println("The secret number is smaller");
            if (tryNumber == secret){
                i = stopGame();
                playerWon = true;
            }
        }
        if (playerWon)
            printCongratulations(tryNumber);
        else
            printLoss();
    }

    private void printCongratulations(int number) {
        System.out.println();
        System.out.println("You guessed it!");
        System.out.println("The secret number is " + number);
    }

    private void printLoss() {
        System.out.println();
        System.out.println("You lose!");
    }

    private int stopGame() {
        return 10;
    }
}