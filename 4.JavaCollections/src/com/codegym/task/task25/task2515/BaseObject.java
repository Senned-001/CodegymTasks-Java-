package com.codegym.task.task25.task2515;

/**
 * The base class for all game objects.
 */
public abstract class BaseObject {
    // Coordinates
    protected double x;
    protected double y;
    // Object radius
    protected double radius;
    // Indicates whether the object is alive
    private boolean isAlive;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isAlive = true;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * This method draws the object on the canvas.
     */
    public void draw(Canvas canvas) {
        // Do nothing
    }

    /**
     * Move by one step.
     */
    public void move() {
        // Do nothing
    }

    /**
     * Check whether (x, y) is beyond the borders.
     */
    public void checkBorders(double minx, double maxx, double miny, double maxy) {
        if (x < minx) x = minx;
        if (x > maxx) x = maxx;
        if (y < miny) y = miny;
        if (y > maxy) y = maxy;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void die() {
        isAlive = false;
    }

    /**
     * Check whether the passed object (o) and the object (this) intersect.
     */
    public boolean intersects(BaseObject o) {
        double dx = x - o.x;
        double dy = y - o.y;
        double destination = Math.sqrt(dx * dx + dy * dy);
        double destination2 = Math.max(radius, o.radius);
        return destination <= destination2;
    }
}