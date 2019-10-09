package com.codegym.task.task23.task2312;

import java.util.ArrayList;

/**
 * Snake class
 */
public class Snake {
    // Direction of snake movement
    private SnakeDirection direction;
    // Whether the snake is alive.
    private boolean isAlive;
    // List of snake parts.
    private ArrayList<SnakeSection> sections;

    public Snake(int x, int y) {
        sections = new ArrayList<SnakeSection>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public ArrayList<SnakeSection> getSections() {
        return sections;
    }

    /**
     * This method moves the snake by one step.
     * The direction of snake movement is given by the variable direction.
     */
    public void move() {
        if (!isAlive) return;

        if (direction == SnakeDirection.UP)
            move(0, -1);
        else if (direction == SnakeDirection.RIGHT)
            move(1, 0);
        else if (direction == SnakeDirection.DOWN)
            move(0, 1);
        else if (direction == SnakeDirection.LEFT)
            move(-1, 0);
    }

    /**
     * This method moves the snake to the adjacent cell.
     * The cell coordinates (dx, dy) are given relative to the snake's current head position.
     */
    private void move(int dx, int dy) {
        // Create a new head (a new "snake section").
        SnakeSection head = sections.get(0);
        head = new SnakeSection(head.getX() + dx, head.getY() + dy);

        // Check whether the snake has slithered beyond the room
        checkBorders(head);
        if (!isAlive) return;

        // Check whether the snake is intersecting itself
        checkBody(head);
        if (!isAlive) return;

        // Check whether the snake ate the mouse.
        Mouse mouse = Room.game.getMouse();
        if (head.getX() == mouse.getX() && head.getY() == mouse.getY()) // Ate it
        {
            sections.add(0, head);                  // Add a new head
            Room.game.eatMouse();                   // We aren't deleting the tail, but we'll create a new mouse.
        } else // Just moving
        {
            sections.add(0, head);                  // Add a new head
            sections.remove(sections.size() - 1);   // Delete the last element with a tail
        }
    }

    /**
     * This method checks whether the new head is inside the room
     */
    private void checkBorders(SnakeSection head) {
        if ((head.getX() < 0 || head.getX() >= Room.game.getWidth()) || head.getY() < 0 || head.getY() >= Room.game.getHeight()) {
            isAlive = false;
        }
    }

    /**
     * This method checks whether the head coincides with some part of the snake's body.
     */
    private void checkBody(SnakeSection head) {
        if (sections.contains(head)) {
            isAlive = false;
        }
    }
}