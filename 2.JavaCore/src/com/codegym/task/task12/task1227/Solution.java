package com.codegym.task.task12.task1227;

/* 
CanFly, CanRun, and CanSwim for the Duck, Penguin, and Toad classes

*/

public class Solution {
    public static void main(String[] args) {
    }

    public interface CanFly {
        public void fly();
    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }

    public class Duck implements CanFly, CanRun,CanSwim {

        @Override
        public void fly(){}

        @Override
        public void run(){}

        @Override
        public void swim(){}
    }

    public class Penguin implements CanRun, CanSwim{

        @Override
        public void run(){}

        @Override
        public void swim(){}
    }

    public class Toad implements  CanSwim{

        @Override
        public void swim(){}
    }
}
