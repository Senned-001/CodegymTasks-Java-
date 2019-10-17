package com.codegym.task.task24.task2413;

/**
 * The base class for all game objects.
 */
public abstract class BaseObject {
    // Coordinates
    protected double x;
    protected double y;
    // Object radius
    protected double radius;

    protected BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
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
    abstract void draw(Canvas canvas);

    /**
     * Move by one step.
     */
    abstract void move();

    /**
     * Check whether (x, y) is beyond the borders.
     */
    void checkBorders(double minx, double maxx, double miny, double maxy) {
        if (x < minx) x = minx;
        if (x > maxx) x = maxx;
        if (y < miny) y = miny;
        if (y > maxy) y = maxy;
    }

    /**
     * Check whether the passed object (o) and the object (this) intersect.
     */
    boolean intersects(BaseObject o) {
        double dx = x - o.x;
        double dy = y - o.y;
        double destination = Math.sqrt(dx * dx + dy * dy);
        double destination2 = Math.max(radius, o.radius);
        return destination <= destination2;
    }
}
