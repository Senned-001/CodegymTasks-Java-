package com.codegym.games.spaceinvaders.gameobjects;

import com.codegym.games.spaceinvaders.Direction;
import com.codegym.games.spaceinvaders.ShapeMatrix;

public class EnemyShip extends Ship{

    public EnemyShip(double x, double y) {
        super(x, y);
        super.setStaticView(ShapeMatrix.ENEMY);
    }

    public void move(Direction direction, double speed){
        switch(direction){
            case RIGHT : {
                x+=speed;
                break;
            }
            case LEFT : {
                x-=speed;
                break;
            }
            case DOWN : {
                y+=2;
                break;
            }
        }
    }
}
