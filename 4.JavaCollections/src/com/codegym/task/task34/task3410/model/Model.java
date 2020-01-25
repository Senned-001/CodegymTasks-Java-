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
    private LevelLoader levelLoader = new LevelLoader(Paths.get(Controller.class.getPackage()+".res.levels.txt"));

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
}
