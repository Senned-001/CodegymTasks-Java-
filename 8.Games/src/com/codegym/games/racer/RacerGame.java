package com.codegym.games.racer;

import com.codegym.engine.cell.*;
import com.codegym.engine.cell.Color;
import com.codegym.games.racer.road.RoadManager;

import java.awt.*;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH/2;
    public static final int ROADSIDE_WIDTH = 14;
    private RoadMarking roadMarking;
    private PlayerCar player;
    private RoadManager roadManager;

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
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene(){
        drawField();
        roadMarking.draw(this);
        player.draw(this);
        roadManager.draw(this);
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
    }

    @Override
    public void onTurn(int step) {
        moveAll();
        roadManager.generateNewRoadObjects(this);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if(key.equals(Key.RIGHT))
            player.setDirection(Direction.RIGHT);
        if(key.equals(Key.LEFT))
            player.setDirection(Direction.LEFT);
    }

    @Override
    public void onKeyReleased(Key key) {
        if((key.equals(Key.RIGHT)&&player.getDirection().equals(Direction.RIGHT))||
                (key.equals(Key.LEFT)&&player.getDirection().equals(Direction.LEFT)))
            player.setDirection(Direction.NONE);
    }
}
