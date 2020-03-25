package com.codegym.games.snake;

import com.codegym.engine.cell.*;

public class Apple extends GameObject {
    private static final String APPLE_SIGN = "A";
    public boolean isAlive = true;

    public Apple(int x, int y) {
        super(x, y);
    }

    public void draw(Game game){
        game.setCellValueEx(x,y, Color.NONE,APPLE_SIGN,Color.GREEN,75);
   }
}
