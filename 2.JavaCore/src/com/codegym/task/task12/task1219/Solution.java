package com.codegym.task.task12.task1219;

/* 
Making a human

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


    public class Human implements CanRun, CanSwim{

        @Override
        public void run(){
        }

        @Override
        public void swim(){
        }
    }

    public class Duck implements CanFly,CanRun,CanSwim{

        @Override
        public void run(){
        }

        @Override
        public void swim(){
        }

        @Override
        public void fly(){
        }
    }

    public class Penguin implements CanRun,CanSwim{

        @Override
        public void run(){
        }

        @Override
        public void swim(){
        }
    }

    public class Airplane implements CanRun,CanFly{

        @Override
        public void run(){
        }

        @Override
        public void fly(){
        }
    }
}
