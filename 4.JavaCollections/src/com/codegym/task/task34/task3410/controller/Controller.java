package com.codegym.task.task34.task3410.controller;

import com.codegym.task.task34.task3410.model.Direction;
import com.codegym.task.task34.task3410.model.GameObjects;
import com.codegym.task.task34.task3410.model.Model;
import com.codegym.task.task34.task3410.view.View;

public class Controller implements EventListener{
    private View view;
    private Model model;

    public Controller() {
        this.model = new Model();
        this.view = new View(this);
        this.view.init();
        this.model.restart();
        model.setEventListener(this);
        view.setEventListener(this);
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
    }

    @Override
    public void move(Direction direction) {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart() {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel() {
        model.startNextLevel();
        view.update();
    }

    @Override
    public void levelCompleted(int level) {
        view.completed(level);
    }

    public GameObjects getGameObjects(){
        return model.getGameObjects();
    }
}
