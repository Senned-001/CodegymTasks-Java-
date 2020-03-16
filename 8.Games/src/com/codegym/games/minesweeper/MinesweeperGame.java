package com.codegym.games.minesweeper;

import com.codegym.engine.cell.*;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;

    @Override
    public void initialize() {
        setScreenSize(SIDE,SIDE);
        createGame();
    }

    private void createGame(){
        for(int i=0;i<SIDE;i++){
            for(int j=0;j<SIDE;j++){
                int n = getRandomNumber(10);
                if(n==1){
                    gameField[j][i]= new GameObject(i,j, true);
                    countMinesOnField++;
                }
                else
                    gameField[j][i]= new GameObject(i,j, false);
                setCellColor(j,i,Color.GRAY);
            }
        }
    }
}
