package com.codegym.games.minesweeper;

import com.codegym.engine.cell.Color;
import com.codegym.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "Ж";
    private static final String FLAG = "P";
    private int countFlags;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countFlags=countMinesOnField;
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors(){
        for(GameObject[] g:gameField){
            for (GameObject o: g){
                if(!o.isMine) {
                    List<GameObject> neighbors = getNeighbors(o);
                    int countOfMinesOfNeighbors = 0;
                    for (GameObject n : neighbors) {
                        if (n.isMine) countOfMinesOfNeighbors++;
                    }
                    o.setCountMineNeighbors(countOfMinesOfNeighbors);
                }
            }
        }
    }

    private void openTile(int x, int y){
        if(gameField[y][x].isMine) setCellValue(x, y, MINE);
        else{
            int countOfMineNeighbors = gameField[y][x].getCountMineNeighbors();
            if(countOfMineNeighbors==0){
                gameField[y][x].isOpen = true;
                setCellValue(x, y, "");
                setCellColor(x, y, Color.AQUA);
                for(GameObject g:getNeighbors(gameField[y][x])){
                    if(!g.isOpen) {
                        openTile(g.x, g.y);
                    }
                }
            }
            else {
                gameField[y][x].isOpen = true;
                setCellNumber(x, y, countOfMineNeighbors);
                setCellColor(x, y, Color.AQUA);
            }
        }

    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        openTile(x,y);
    }
}