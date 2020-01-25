package com.codegym.task.task34.task3410.controller;

import com.codegym.task.task34.task3410.model.Direction;

public interface EventListener {
    void move(Direction direction);         // moves the object in the specified direction.
    void restart();                         //restart the current level.
    void startNextLevel();
    void levelCompleted(int level);
}
