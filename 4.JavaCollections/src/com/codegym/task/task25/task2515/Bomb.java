package com.codegym.task.task25.task2515;

/**
 * Bomb class
 */
public class Bomb extends BaseObject {
    public Bomb(double x, double y) {
        super(x, y, 1);
    }

    /**
     * Draw the object on the canvas.
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'B');
    }

    /**
     * Move the object down by one step.
     */
    @Override
    public void move() {
        y++;
    }
}