package com.codegym.games.snake;

import com.codegym.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH=15;
    public static final int HEIGHT=15;

    @Override
    public void initialize() {
        setScreenSize(WIDTH,HEIGHT);
        createGame();
    }

    private void drawScene(){
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellColor(x, y, Color.GREY);
            }
        }
    }

    private void createGame(){
        drawScene();
        Apple apple = new Apple(7,7);
        apple.draw(this);
    }
}
