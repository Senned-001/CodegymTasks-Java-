package com.codegym.task.task21.task2113;

import java.util.*;

public class Hippodrome {
    private static List<Horse> horses = new ArrayList<>();

    static Hippodrome game;

    public static void main(String[] args) {
        horses.add(new Horse("Pinky",3,0));
        horses.add(new Horse("Brain",3,0));
        horses.add(new Horse("Brian",3,0));
        game=new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run(){
        for (int i=0;i<100;i++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move(){
        for (Horse x:horses) {
            x.move();
        }
    }

    public void print(){
        for (Horse x:horses) {
            x.print();
        }
        for(int i=0;i<10;i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse a=null;
        double max=0;
        for (Horse x:horses) {
            if(max<x.getDistance()){
                max = x.getDistance();
                a=x;
            }
        }
        return a;
    }

    public void printWinner(){
        System.out.println("The winner is "+getWinner().getName()+"!");
    }
}
