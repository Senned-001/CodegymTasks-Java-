package com.codegym.games.racer;

import com.codegym.engine.cell.*;
import com.codegym.engine.cell.Color;

import java.awt.*;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH/2;
    public static final int ROADSIDE_WIDTH = 14;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame(){
        drawScene();
    }

    private void drawScene(){
        drawField();
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
}
