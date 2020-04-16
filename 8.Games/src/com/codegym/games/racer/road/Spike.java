package com.codegym.games.racer.road;

public class Spike extends RoadObject{

    public Spike(int x, int y) {
        super(RoadObjectType.SPIKE, x, y);
        this.speed = 0;
    }
}
