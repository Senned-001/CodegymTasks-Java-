package com.codegym.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class Controller extends KeyAdapter {
    private Model model;
    private View view;
    private static final int WINNING_TILE = 2048;

    public Controller(Model model) {
        this.model = model;
        this.view=new View(this);
    }

    public View getView() {
        return view;
    }

    public Tile[][] getGameTiles(){
        return model.getGameTiles();
    }

    public int getScore(){
        return model.score;
    }

    public void resetGame(){
        view.isGameLost=false;
        view.isGameWon=false;
        model.maxTile=0;
        model.score=0;
        model.resetGameTiles();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==VK_ESCAPE) resetGame();
        if(!model.canMove()) view.isGameLost=true;
        if(!view.isGameLost&&!view.isGameWon){
            switch (e.getKeyCode()) {
                case VK_LEFT: model.left();
                case VK_RIGHT: model.right();
                case VK_UP: model.up();
                case VK_DOWN: model.down();
                case VK_Z: model.rollback();
            }
        }
        if(model.maxTile==WINNING_TILE) view.isGameWon=true;
        view.repaint();
    }
}
