package com.codegym.task.task34.task3410.model;

import java.awt.*;

public class Player extends CollisionObject implements Movable {

    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.blue);

        graphics.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
