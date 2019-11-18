package com.codegym.task.task28.task2809;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/* 
Plants vs Zombies

*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        List<Character> characters = new ArrayList<>();
        characters.add(new Plant());
        characters.add(new Plant());
        characters.add(new Zombie());
        characters.add(new Zombie());
        characters.add(new Zombie());

        start(characters);
    }

    private static boolean isEveryoneReady = false;

    private static void start(List<Character> characters) throws InterruptedException {
        final Phaser phaser = new Phaser(1 + characters.size());

        for (final Character character : characters) {
            final String member = character.toString();
            System.out.println(member + " joined the game");
            new Thread() {
                @Override
                public void run() {
                    System.out.println(member + " is preparing to play");
                    phaser.arriveAndAwaitAdvance(); //all threads wait becaouse we have 5 threads and one main, with 6 phase, 5 wait main
                    if (!isEveryoneReady) {
                        isEveryoneReady = true;

                        System.out.println("The game has begun!");
                    }
                    character.run();    //here we set off phase of main threat and it sets 5/5 and game starts

                }
            }.start();
        }

        phaser.arriveAndDeregister();
    }
}
