package com.codegym.task.task24.task2413;

/**
 * The paddle is used to bounce back the ball.
 */
public class Paddle extends BaseObject {
    // Picture for drawing
    private static int[][] matrix = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
    };
    // Speed
    private double speed = 1;
    // Direction (-1: to the left, +1: to the right)
    private double direction = 0;

    public Paddle(double x, double y) {
        super(x, y, 3);
    }

    /**
     * This method moves the paddle according to the direction variable.
     */
    void move() {
        double dx = speed * direction;
        x = x + dx;

        checkBorders(radius, Arkanoid.game.getWidth() - radius + 1, 1, Arkanoid.game.getHeight() + 1);
    }

    /**
     * Set direction to -1
     */
    void moveLeft() {
        direction = -1;
    }

    /**
     * Set direction to +1
     */
    void moveRight() {
        direction = 1;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    /**
     * Draw the object on the canvas
     */
    @Override
    void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'M');
    }
}
