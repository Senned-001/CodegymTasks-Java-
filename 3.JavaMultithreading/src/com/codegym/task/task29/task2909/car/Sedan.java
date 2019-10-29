package com.codegym.task.task29.task2909.car;

public class Sedan extends Car{
    public Sedan(int numberOfPassengers) {
        super(SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}