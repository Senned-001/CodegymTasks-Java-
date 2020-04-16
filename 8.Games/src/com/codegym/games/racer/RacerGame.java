package com.codegym.games.racer;

import com.codegym.engine.cell.*;
import com.codegym.engine.cell.Color;
import com.codegym.games.racer.road.RoadManager;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH/2;
    public static final int ROADSIDE_WIDTH = 14;
    private RoadMarking roadMarking;
    private PlayerCar player;
    private RoadManager roadManager;
    private boolean isGameStopped;
    private FinishLine finishLine;
    private static final int RACE_GOAL_CARS_COUNT = 40;
    private ProgressBar progressBar;
    private int score;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame(){
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        isGameStopped = false;
        finishLine = new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        score = 3500;
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene(){
        drawField();
        roadMarking.draw(this);
        player.draw(this);
        roadManager.draw(this);
        finishLine.draw(this);
        progressBar.draw(this);
    }

    private void drawField(){
        for(int i=0;i<HEIGHT;i++){
            for(int j=0;j<WIDTH;j++){
                if((j>=0&&j<ROADSIDE_WIDTH)||(j>=WIDTH - ROADSIDE_WIDTH&&j<WIDTH))
                    setCellColor(j,i,Color.GRAY);
                if(j>=ROADSIDE_WIDTH&&j<WIDTH - ROADSIDE_WIDTH&&j!=CENTER_X)
                    setCellColor(j,i,Color.BLACK);
                if(j==CENTER_X)
                    setCellColor(j,i,Color.WHITE);
            }
        }
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if(x<WIDTH&&x>=0&&y<HEIGHT&&y>=0)
            super.setCellColor(x, y, color);
    }

    private void moveAll(){
        roadMarking.move(player.speed);
        player.move();
        roadManager.move(player.speed);
        finishLine.move(player.speed);
        progressBar.move(roadManager.getPassedCarsCount());
    }

    @Override
    public void onTurn(int step) {
        if(roadManager.getPassedCarsCount()>=RACE_GOAL_CARS_COUNT)
            finishLine.show();
        if(finishLine.isCrossed(player))
            win();
        else if(roadManager.checkCrash(player))
            gameOver();
        else {
            moveAll();
            roadManager.generateNewRoadObjects(this);
            score-=5;
            setScore(score);
        }
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if(key.equals(Key.RIGHT))
            player.setDirection(Direction.RIGHT);
        if(key.equals(Key.LEFT))
            player.setDirection(Direction.LEFT);
        if(key.equals(Key.SPACE)&&isGameStopped)
            createGame();
        if(key.equals(Key.UP))
            player.speed = 2;
    }

    @Override
    public void onKeyReleased(Key key) {
        if((key.equals(Key.RIGHT)&&player.getDirection().equals(Direction.RIGHT))||
                (key.equals(Key.LEFT)&&player.getDirection().equals(Direction.LEFT)))
            player.setDirection(Direction.NONE);
        if(key.equals(Key.UP))
            player.speed = 1;
    }

    private void gameOver(){
        isGameStopped = true;
        stopTurnTimer();
        player.stop();
        showMessageDialog(Color.RED, "Game Over!", Color.WHITE, 18);
    }

    private void win(){
        isGameStopped = true;
        stopTurnTimer();
        showMessageDialog(Color.GREEN, "You Won!", Color.WHITE, 18);
    }
}
