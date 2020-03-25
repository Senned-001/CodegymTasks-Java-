package com.codegym.games.snake;

import com.codegym.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "O";
    private static final String BODY_SIGN = "o";
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    public Snake(int x, int y) {
        this.snakeParts.add(new GameObject(x,y));
        this.snakeParts.add(new GameObject(x+1,y));
        this.snakeParts.add(new GameObject(x+2,y));
    }

    public void draw(Game game){
        if(isAlive) {
            for (int i = 0; i < snakeParts.size(); i++) {
                if (i == 0)
                    game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, HEAD_SIGN, Color.GREEN, 75);
                else
                    game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, Color.GREEN, 75);
            }
        }
        else {
            for (int i = 0; i < snakeParts.size(); i++) {
                if (i == 0)
                    game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, HEAD_SIGN, Color.RED, 75);
                else
                    game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, Color.RED, 75);
            }
        }
    }

    public void setDirection(Direction direction) {
        if(this.direction==Direction.LEFT&&direction!=Direction.RIGHT||
                this.direction==Direction.RIGHT&&direction!=Direction.LEFT||
                this.direction==Direction.UP&&direction!=Direction.DOWN||
                this.direction==Direction.DOWN&&direction!=Direction.UP) {
            if (((this.direction == Direction.RIGHT || this.direction == Direction.LEFT) && snakeParts.get(0).x == snakeParts.get(1).x) ||
                    ((this.direction == Direction.UP || this.direction == Direction.DOWN) && snakeParts.get(0).y == snakeParts.get(1).y)){
                return;
            }
                this.direction = direction;
        }
    }

    public void move(Apple apple){
        GameObject newHead = createNewHead();
        if(newHead.x<0||newHead.x>=SnakeGame.WIDTH||newHead.y<0||newHead.y>=SnakeGame.HEIGHT)
            isAlive=false;
        else {
            if(checkCollision(newHead)) {
                isAlive=false;
                return;
            }
            snakeParts.add(0, newHead);
            if(newHead.x==apple.x&&newHead.y==apple.y) {
                apple.isAlive=false;
            }
            else removeTail();
        }
    }

    public GameObject createNewHead(){
        switch(direction){
            case UP : return new GameObject(snakeParts.get(0).x,snakeParts.get(0).y-1);
            case DOWN : return new GameObject(snakeParts.get(0).x,snakeParts.get(0).y+1);
            case LEFT : return new GameObject(snakeParts.get(0).x-1,snakeParts.get(0).y);
            case RIGHT : return new GameObject(snakeParts.get(0).x+1,snakeParts.get(0).y);
        }
        return null;
    }

    public void removeTail(){
        snakeParts.remove(snakeParts.size()-1);
    }

    public boolean checkCollision(GameObject gameObject){
        for(GameObject g : snakeParts) {
            if (g.x==gameObject.x&&g.y==gameObject.y) return true;
        }
        return false;
    }

    public int getLength(){
        return snakeParts.size();
    }
}
