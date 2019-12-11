package com.codegym.task.task25.task2515;

/**
 * Rocket class
 */
public class Rocket extends BaseObject {

    public Rocket(double x, double y) {
        super(x, y, 1);
    }

    /**
     * This method draws the object on the canvas.
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'R');
    }

    /**
     * Move the object up by one step.
     */
    @Override
    public void move() {
        y--;
    }
}