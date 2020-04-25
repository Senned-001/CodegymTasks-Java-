package com.codegym.games.spaceinvaders.gameobjects;

public class Ship extends GameObject{

    public Ship(double x, double y) {
        super(x, y);
    }

    public void setStaticView(int[][] viewFrame){
        super.setMatrix(viewFrame);
    }
}
