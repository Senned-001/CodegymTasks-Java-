package com.codegym.task.task24.task2413;

/**
 * The class for the game ball
 */
public class Ball extends BaseObject {
    private double speed;
    // Direction (0 to 360 degrees)
    private double direction;

    // Current direction vector (dx, dy)
    private double dx;
    private double dy;

    // Is the object frozen or movable?
    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);

        this.direction = direction;
        this.speed = speed;

        this.isFrozen = true;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    /**
     * Set a new direction.
     * We also calculate the new vector here.
     * This method is convenient for rebounding off walls.
     */
    void setDirection(double direction) {
        this.direction = direction;

        double angel = Math.toRadians(direction);
        dx = Math.cos(angel) * speed;
        dy = -Math.sin(angel) * speed;
    }

    /**
     * Draw the object on the canvas.
     */
    @Override
    void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'O');
    }

    /**
     * Move by one step.
     */
    public void move() {
        if (isFrozen) return;

        x += dx;
        y += dy;

        checkRebound(1, Arkanoid.game.getWidth(), 1, Arkanoid.game.getHeight() + 5);
    }

    /**
     * Check whether the ball has flown beyond the wall.
     * If it has, then bounce it.
     */
    void checkRebound(int minx, int maxx, int miny, int maxy) {
        if (x < minx) {
            x = minx + (minx - x);
            dx = -dx;
        }

        if (x > maxx) {
            x = maxx - (x - maxx);
            dx = -dx;
        }

        if (y < miny) {
            y = miny + (miny - y);
            dy = -dy;
        }

        if (y > maxy) {
            y = maxy - (y - maxy);
            dy = -dy;
        }
    }

    /**
     * Launch the ball.
     * isFrozen = false.
     * Recalculate the direction vector (dx,dy).
     */
    void start() {
        this.setDirection(direction);
        this.isFrozen = false;
    }
}
