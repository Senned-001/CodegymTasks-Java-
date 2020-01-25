package com.codegym.task.task34.task3410.model;

import java.awt.*;

public class StorageLocation extends GameObject{

    public StorageLocation(int x, int y) {
        super(x, y, 2, 2);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.drawOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}
