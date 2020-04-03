package com.codegym.games.game2048;

import com.codegym.engine.cell.*;


public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE,SIDE);
        createGame();
        drawScene();
    }

    private void createGame(){
        gameField = new int[SIDE][SIDE];
        score=0;
        setScore(score);
        createNewNumber();
        createNewNumber();
    }

    private void drawScene(){
        for(int i=0;i<SIDE;i++){
            for(int j=0;j<SIDE;j++){
                setCellColoredNumber(i,j,gameField[j][i]);
            }
        }
    }

    private void createNewNumber(){
        if(getMaxTileValue()==2048){
            win();
            return;
        }
        int x;
        int y;
        do {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        }while (gameField[x][y]!=0);
        int value = getRandomNumber(10);
        if(value==9) gameField[x][y] = 4;
        else gameField[x][y] = 2;
    }

    private Color getColorByValue(int value){
        switch (value){
            case 0 : return Color.GRAY;
            case 2 : return Color.GREEN;
            case 4 : return Color.YELLOW;
            case 8 : return Color.ORANGE;
            case 16 : return Color.DARKORANGE;
            case 32 : return Color.MAGENTA;
            case 64 : return Color.DARKMAGENTA;
            case 128 : return Color.PINK;
            case 256 : return Color.DEEPPINK;
            case 512 : return Color.MEDIUMVIOLETRED;
            case 1024 : return Color.RED;
            case 2048 : return Color.DARKRED;
        }
        return Color.GRAY;
    }

    private void setCellColoredNumber(int x, int y, int value){
        Color color = getColorByValue(value);
        if(value!=0)
            setCellValueEx(x,y,color,"" + value);
        else
            setCellValueEx(x,y,color,"");
    }

    private boolean compressRow(int[] row){
        boolean flagIsChanged = false;
        for(int m = 0;m < row.length; m++) {
            for (int j = 0; j < row.length-1; j++) {
                if (row[j]==0&&row[j + 1]!=0) {
                    int temp = row[j];
                    row[j] = row[j + 1];
                    row[j + 1] = temp;
                    flagIsChanged = true;
                }
            }
        }
        return flagIsChanged;
    }

    private boolean mergeRow(int[] row){
        boolean flagIsChanged = false;
        for (int j = 0; j < row.length-1; j++) {
            if(row[j]==row[j + 1]&&row[j]!=0){
                row[j] += row[j + 1];
                row[j + 1] = 0;
                score+=row[j];
                setScore(score);
                flagIsChanged = true;
            }
        }
        return flagIsChanged;
    }

    private void moveLeft(){
        boolean changed = false;
        for (int j = 0; j < SIDE; j++) {
            if(compressRow(gameField[j])|mergeRow(gameField[j])|compressRow(gameField[j]))
                changed = true;
        }
        if(changed)
            createNewNumber();
    }

    private void moveRight(){
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveDown(){
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp(){
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void restart() {
        isGameStopped = false;
        createGame();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE)
                restart();
        }else {
            if (!canUserMove()) {
                gameOver();
                if (key == Key.SPACE) {
                    restart();
                }
                return;
            }

            switch (key) {
                case DOWN: {
                    moveDown();
                    break;
                }
                case UP: {
                    moveUp();
                    break;
                }
                case LEFT: {
                    moveLeft();
                    break;
                }
                case RIGHT: {
                    moveRight();
                    break;
                }
                default:
                    return;
            }
            drawScene();
        }
    }

    private void rotateClockwise(){
        int temp [][] = new int[SIDE][SIDE];
        for(int i = 0;i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                temp[i][j]=gameField[SIDE-1-j][i];
            }
        }
        gameField = temp;
    }

    private int getMaxTileValue(){
        int max = 0;
        for(int i = 0;i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if(gameField[i][j]>max)
                    max = gameField[i][j];
            }
        }
        return max;
    }

    private void win(){
        showMessageDialog(Color.AQUA,"You're win!",Color.FLORALWHITE, 18);
        isGameStopped = true;
    }

    private boolean canUserMove(){
        for(int i = 0;i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if(gameField[i][j]==0){
                    return true;
                }
            }
        }
        for(int i = 0;i < SIDE; i++) {
            for (int j = 0; j < SIDE - 1; j++) {
                if (gameField[i][j] == gameField[i][j + 1])
                    return true;
            }
        }
        for(int i = 0;i < SIDE-1; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j] == gameField[i + 1][j])
                    return true;
            }
        }
        return false;
    }

    private void gameOver(){
        showMessageDialog(Color.RED,"Game Over!",Color.FLORALWHITE, 18);
        isGameStopped = true;
    }
}
