package com.codegym.task.task34.task3410.model;

import java.awt.*;

public class Wall extends CollisionObject{

    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.gray);
        graphics.drawOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}
