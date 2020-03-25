package com.codegym.games.snake;

import com.codegym.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH=15;
    public static final int HEIGHT=15;
    private Snake snake;
    private int turnDelay;
    private Apple apple;
    private boolean isGameStopped;
    private static final int GOAL = 28;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH,HEIGHT);
        createGame();
    }

    private void drawScene(){
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y,Color.GREY, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    private void createGame(){
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        turnDelay = 300;
        setTurnTimer(turnDelay);
        createNewApple();
        isGameStopped=false;
        score=0;
        setScore(score);
        drawScene();
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if(!apple.isAlive) {
            score+=5;
            setScore(score);
            createNewApple();
            turnDelay-=10;
            setTurnTimer(turnDelay);
        }
        if(!snake.isAlive) gameOver();
        if(snake.getLength()>GOAL) win();

        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        switch(key){
            case LEFT : {
                snake.setDirection(Direction.LEFT);
                break;
            }
            case RIGHT: {
                snake.setDirection(Direction.RIGHT);
                break;
            }
            case UP: {
                snake.setDirection(Direction.UP);
                break;
            }
            case DOWN: {
                snake.setDirection(Direction.DOWN);
                break;
            }
            case SPACE: {
                if(isGameStopped) createGame();
                break;
            }
        }
    }

    private void createNewApple() {
        apple = new Apple(getRandomNumber(WIDTH),getRandomNumber(HEIGHT));
        while(snake.checkCollision(apple)) {
            apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
        }
    }

    private void gameOver(){
        stopTurnTimer();
        isGameStopped=true;
        showMessageDialog(Color.RED,"GAME OVER!", Color.WHITE,18);
    }

    private void win(){
        stopTurnTimer();
        isGameStopped=true;
        showMessageDialog(Color.GREEN,"YOU WIN", Color.WHITE,18);
    }
}
