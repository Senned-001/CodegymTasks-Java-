package com.codegym.task.task13.task1301;

/* 
Beer

*/
public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Drinker {

        void askForMore(String message);

        void sayThankYou();

        boolean isReadyToGoHome();
    }

    public interface Alcoholic extends Drinker {
        boolean READY_TO_GO_HOME = false;

        void sleepOnTheFloor();

        @Override
        void askForMore(String message);

        @Override
        void sayThankYou();

        @Override
        boolean isReadyToGoHome();
    }

    public static class  BeerLover implements Alcoholic{

        @Override
        public void sleepOnTheFloor(){}

        @Override
        public void askForMore(String message){}

        @Override
        public void sayThankYou(){}

        @Override
        public boolean isReadyToGoHome(){return READY_TO_GO_HOME;}
    }
}