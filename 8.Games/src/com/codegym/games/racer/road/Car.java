package com.codegym.games.racer.road;

public class Car extends RoadObject{

    public Car(RoadObjectType type, int x, int y) {
        super(type, x, y);
        this.speed = 1;
    }
}
