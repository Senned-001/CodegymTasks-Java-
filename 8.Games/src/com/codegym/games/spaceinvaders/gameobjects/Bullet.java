package com.codegym.games.spaceinvaders.gameobjects;

import com.codegym.games.spaceinvaders.Direction;
import com.codegym.games.spaceinvaders.ShapeMatrix;

public class Bullet extends GameObject {
    private int dy;
    public boolean isAlive = true;

    public Bullet(double x, double y, Direction direction) {
        super(x, y);
        super.setMatrix(ShapeMatrix.BULLET);
        if(direction.equals(Direction.UP))
            dy = -1;
        else 
            dy = 1;
    }

    public void move(){
        y += dy;
    }

    public void kill(){
        isAlive = false;
    }
}
