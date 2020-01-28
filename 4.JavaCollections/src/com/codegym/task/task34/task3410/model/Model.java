package com.codegym.task.task34.task3410.model;

import com.codegym.task.task34.task3410.controller.Controller;
import com.codegym.task.task34.task3410.controller.EventListener;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Model {
    private EventListener eventListener;
    public static final int BOARD_CELL_SIZE = 20;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(new File(getClass().getResource("../res/levels.txt").getFile()).toPath());

    public void setEventListener(EventListener eventListener){
        this.eventListener=eventListener;
    }

    public GameObjects getGameObjects(){
        return this.gameObjects;
    }

    public void restartLevel(int level){
        this.gameObjects = levelLoader.getLevel(level);
    }

    public void restart(){
        restartLevel(this.currentLevel);
    }

    public void startNextLevel(){
        this.currentLevel++;
        restart();
    }

    public void move(Direction direction){
        Player player = gameObjects.getPlayer();
        if(checkWallCollision(player,direction))
            return;
        if(checkBoxCollisionAndMoveIfAvaliable(direction))
            return;
        switch(direction){
            case LEFT : {
                player.move(-BOARD_CELL_SIZE,0);
                break;
            }
            case RIGHT : {
                player.move(BOARD_CELL_SIZE,0);
                break;
            }
            case UP : {
                player.move(0,-BOARD_CELL_SIZE);
                break;
            }
            case DOWN : {
                player.move(0,BOARD_CELL_SIZE);
                break;
            }
        }
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        for(CollisionObject wall: gameObjects.getWalls()){
            if(gameObject.isCollision(wall,direction))
                return true;
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction){
        Player player = gameObjects.getPlayer();
       
        for(Box box: gameObjects.getBoxes()){                           //check collision of player with boxes
            if(player.isCollision(box,direction)){                      //if founded
                if(checkWallCollision(box,direction))                   //check collision of this box with walls
                    return true;
                for(Box otherBox: gameObjects.getBoxes()){  //if not founded check collision of this box with other boxes
                    if(!otherBox.equals(box)){
                        if(box.isCollision(otherBox,direction)){
                            return true;
                        }
                    }
                }
                //if there is not collision for founded box - move them
                switch(direction){
                    case LEFT : {
                        box.move(-BOARD_CELL_SIZE,0);
                        break;
                    }
                    case RIGHT : {
                        box.move(BOARD_CELL_SIZE,0);
                        break;
                    }
                    case UP : {
                        box.move(0,-BOARD_CELL_SIZE);
                        break;
                    }
                    case DOWN : {
                        box.move(0,BOARD_CELL_SIZE);
                        break;
                    }
                }
            }
        }
        return false;                               //if not collisions for player
    }

    public void checkCompletion(){
        int counter = 0;
        for(Box box : gameObjects.getBoxes()){
            for(StorageLocation sl : gameObjects.getStorageLocations()){
                if(box.getX()==sl.getX()&&box.getY()==sl.getY()){
                    counter++;
                    break;
                }
            }
        }
        if(counter==gameObjects.getBoxes().size())
            this.eventListener.levelCompleted(currentLevel);
    }
}
