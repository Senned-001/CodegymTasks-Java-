package com.codegym.games.racer.road;

import com.codegym.games.racer.GameObject;
import com.codegym.games.racer.ShapeMatrix;

import java.util.List;

public class RoadObject extends GameObject {
    public RoadObjectType type;
    public int speed;
    
    public RoadObject(RoadObjectType type, int x, int y) {
        super(x, y);
        this.type = type;
        this.matrix = getMatrix(type);
        this.width = matrix[0].length;
        this.height = matrix.length;
    }

    /**
     * The method responsible for moving an obstacle. An obstacle can have its own speed and a secondary speed
     * that depends on the player's speed.
     */
    public void move(int boost, List<RoadObject> items) {
        this.y += boost;
    }

    /**
     * Checks whether the images of the current object and the passed object are
     * closer than the value of the distance parameter.
     * For example, if the distance 12 is passed and the 2 objects are separated by less than
     * 12 cells on the playing field, the method returns true. Otherwise, it returns false.
     */
    public boolean isCollisionWithDistance(RoadObject roadObject, int distance) {
        if ((x - distance > roadObject.x + roadObject.width) || (x + width + distance < roadObject.x)) {
            return false;
        }

        if ((y - distance > roadObject.y + roadObject.height) || (y + height + distance < roadObject.y)) {
            return false;
        }

        return true;
    }

    /**
     * Returns the object's image matrix based on its type.
     */
    private static int[][] getMatrix(RoadObjectType type) {
        switch (type) {
            case CAR:
                return ShapeMatrix.PASSENGER_CAR;
            case BUS:
                return ShapeMatrix.BUS;
            case SPORT_CAR:
                return ShapeMatrix.SPORT_CAR;
            case SPIKE:
                return ShapeMatrix.SPIKE;
            case DRUNK_CAR:
                return ShapeMatrix.DRUNK_CAR;
            default:
                return ShapeMatrix.TRUCK;
        }
    }

    /**
     * Returns the object's height.
     */
    public static int getHeight(RoadObjectType type) {
        return getMatrix(type).length;
    }
}