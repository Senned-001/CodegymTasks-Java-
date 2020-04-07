package com.codegym.games.moonlander;

import com.codegym.engine.cell.*;

import static com.codegym.engine.cell.Key.UP;

public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;
    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;


    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
        showGrid(false);
    }

    private void createGame(){
        isUpPressed = false;
        isLeftPressed = false;
        isRightPressed = false;
        createGameObjects();
        drawScene();
        setTurnTimer(50);
    }

    private void drawScene(){
        for(int y = 0; y<HEIGHT; y++){
            for(int x = 0; x <WIDTH; x++){
                setCellColor(x,y,Color.BLACK);
            }
        }
        rocket.draw(this);
        landscape.draw(this);
    }

    private void createGameObjects(){
        rocket = new Rocket(WIDTH/2,0);
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
    }

    @Override
    public void onTurn(int step) {
        rocket.move(isUpPressed,isLeftPressed,isRightPressed);
        drawScene();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if(x>=0&&x<WIDTH&&y>=0&&y<HEIGHT)
            super.setCellColor(x, y, color);
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key){
            case UP : {
                isUpPressed = true;
                break;
            }
            case RIGHT : {
                isRightPressed = true;
                isLeftPressed= false;
                break;
            }
            case LEFT : {
                isRightPressed = false;
                isLeftPressed= true;
                break;
            }
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        switch (key){
            case UP : {
                isUpPressed = false;
                break;
            }
            case RIGHT : {
                isRightPressed = false;
                break;
            }
            case LEFT : {
                isLeftPressed= false;
                break;
            }
        }
    }
}
