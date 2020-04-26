package com.codegym.games.spaceinvaders;

import com.codegym.engine.cell.*;
import com.codegym.games.spaceinvaders.gameobjects.EnemyFleet;
import com.codegym.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;
    private EnemyFleet enemyFleet;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame(){
        createStars();
        enemyFleet =  new EnemyFleet();
        setTurnTimer(40);
        drawScene();
    }

    private void drawField(){
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }
        for(Star s: stars){
            s.draw(this);
        }
    }

    private void drawScene(){
        drawField();
        enemyFleet.draw(this);
    }

    private void createStars(){
        stars = new ArrayList<>();
        for(int i = 1; i <= 8;i++)
            stars.add(new Star(i,i));
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        drawScene();
    }

    private void moveSpaceObjects(){
        enemyFleet.move();
    }
}
