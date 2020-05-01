package com.codegym.games.spaceinvaders;

import com.codegym.engine.cell.*;
import com.codegym.games.spaceinvaders.gameobjects.Bullet;
import com.codegym.games.spaceinvaders.gameobjects.EnemyFleet;
import com.codegym.games.spaceinvaders.gameobjects.PlayerShip;
import com.codegym.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    public static final int DIFFICULTY = 5;
    private List<Bullet> enemyBullets;
    private PlayerShip playerShip;
    private boolean isGameStopped;
    private int animationsCount;
    private List<Bullet> playerBullets;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame(){
        createStars();
        enemyFleet =  new EnemyFleet();
        setTurnTimer(40);
        enemyBullets =  new ArrayList<>();
        playerShip = new PlayerShip();
        isGameStopped = false;
        animationsCount = 0;
        playerBullets = new ArrayList<>();
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
        for(Bullet b:enemyBullets){
            b.draw(this);
        }
        playerShip.draw(this);
        for(Bullet b:playerBullets){
            b.draw(this);
        }
    }

    private void createStars(){
        stars = new ArrayList<>();
        for(int i = 1; i <= 8;i++)
            stars.add(new Star(i,i));
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();
        Bullet newBullet = enemyFleet.fire(this);
        if(newBullet!=null)
            enemyBullets.add(newBullet);
        drawScene();
    }

    private void moveSpaceObjects(){
        enemyFleet.move();
        for(Bullet b:enemyBullets){
            b.move();
        }
        playerShip.move();
        for(Bullet b:playerBullets){
            b.move();
        }
    }

    private void removeDeadBullets(){
        enemyBullets.removeIf(b -> !b.isAlive || b.y >= HEIGHT - 1);
    }

    private void check(){
        playerShip.checkHit(enemyBullets);
        removeDeadBullets();
        if(!playerShip.isAlive)
            stopGameWithDelay();
    }

    private void stopGame(boolean isWin){
        isGameStopped = true;
        stopTurnTimer();
        if(isWin)
            showMessageDialog(Color.WHITE,"You're Win!", Color.GREEN,18);
        else
            showMessageDialog(Color.WHITE,"Game Over!", Color.RED,18);
    }

    private void stopGameWithDelay(){
        animationsCount++;
        if(animationsCount>=10)
            stopGame(playerShip.isAlive);
    }

    @Override
    public void onKeyPress(Key key) {
        if(isGameStopped == true&&key.equals(Key.SPACE))
            createGame();
        if(key.equals(Key.LEFT))
            playerShip.setDirection(Direction.LEFT);
        if(key.equals(Key.RIGHT))
            playerShip.setDirection(Direction.RIGHT);
    }

    @Override
    public void onKeyReleased(Key key) {
        if((key.equals(Key.LEFT)&&playerShip.getDirection().equals(Direction.LEFT))||
                (key.equals(Key.RIGHT)&&playerShip.getDirection().equals(Direction.RIGHT)))
            playerShip.setDirection(Direction.UP);

    }
}
