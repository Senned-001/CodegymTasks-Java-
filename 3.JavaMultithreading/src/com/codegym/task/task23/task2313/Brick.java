package com.codegym.task.task24.task2413;

/**
 * Class for brick objects.
 */
public class Brick extends BaseObject {
    // Picture for drawing
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
    };

    public Brick(double x, double y) {
        super(x, y, 3);
    }

    /**
     * Draw the object on the canvas
     */
    @Override
    void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'H');
    }

    /**
     * Do nothing - the brick doesn't move.
     */
    @Override
    void move() {
        // Do nothing
    }
}
