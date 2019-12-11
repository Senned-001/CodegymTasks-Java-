package com.codegym.task.task25.task2515;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * The game's main class is Space
 */
public class Space {
    // Width and height of the game field
    private int width;
    private int height;

    // Spaceship
    private Spaceship ship;
    // List of UFOs
    private List<Ufo> ufos = new ArrayList<Ufo>();
    // List of bombs
    private List<Bomb> bombs = new ArrayList<Bomb>();
    // List of rockets
    private List<Rocket> rockets = new ArrayList<Rocket>();

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * The program's main loop.
     * This is where all the important actions happen
     */
    public void run() {
        // Create a drawing canvas.
        Canvas canvas = new Canvas(width, height);

        // Create a KeyboardObserver object and start it.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        // The game continues as long as the ship is alive
        while (ship.isAlive()) {
            // Does the observer have any key events?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                // If "left arrow", then move the game piece to the left
                System.out.print(event.getKeyCode());
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    ship.moveLeft();
                    // If "right arrow", then move the game piece to the right
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    ship.moveRight();
                    // If "space", then launch a ball
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    ship.fire();
            }

            // Move all of the objects in the game
            moveAllItems();

            // Detect collisions
            checkBombs();
            checkRockets();
            // Remove dead objects from the list
            removeDead();

            // Create a UFO (once in every 10 calls)
            createUfo();

            // Draw all the objects on the canvas and display the canvas on the screen
            canvas.clear();
            draw(canvas);
            canvas.print();

            // Pause 300 milliseconds
            Space.sleep(300);
        }

        // Display "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Move all of the objects in the game
     */
    public void moveAllItems() {
        for (BaseObject object : getAllItems()) {
            object.move();
        }
    }

    /**
     * The method returns a single list that contains all objects in the game
     */
    public List<BaseObject> getAllItems() {
        ArrayList<BaseObject> list = new ArrayList<BaseObject>(ufos);
        list.add(ship);
        list.addAll(bombs);
        list.addAll(rockets);
        return list;
    }

    /**
     * Create a new UFO. Once in every 10 calls.
     */
    public void createUfo() {
        if (ufos.size() > 0) return;

        int random10 = (int) (Math.random() * 10);
        if (random10 == 0) {
            double x = Math.random() * width;
            double y = Math.random() * height / 2;
            ufos.add(new Ufo(x, y));
        }
    }

    /**
     * Check the bombs.
     * a) collision with a ship (the bomb and the ship die)
     * b) movement beyond the bottom of the game field (the bomb dies)
     */
    public void checkBombs() {
        for (Bomb bomb : bombs) {
            if (ship.intersects(bomb)) {
                ship.die();
                bomb.die();
            }

            if (bomb.getY() >= height)
                bomb.die();
        }
    }

    /**
     * Check the rockets.
     * a) collision with a UFO (the rocket and the UFO die)
     * b) movement beyond the top of the playing field (the rocket dies)
     */
    public void checkRockets() {
        for (Rocket rocket : rockets) {
            for (Ufo ufo : ufos) {
                if (ufo.intersects(rocket)) {
                    ufo.die();
                    rocket.die();
                }
            }

            if (rocket.getY() <= 0)
                rocket.die();
        }
    }

    /**
     * Remove dead objects (bombs, rockets, ufos) from the lists
     */
    public void removeDead() {
        for (BaseObject object : new ArrayList<BaseObject>(bombs)) {
            if (!object.isAlive())
                bombs.remove(object);
        }

        for (BaseObject object : new ArrayList<BaseObject>(rockets)) {
            if (!object.isAlive())
                rockets.remove(object);
        }

        for (BaseObject object : new ArrayList<BaseObject>(ufos)) {
            if (!object.isAlive())
                ufos.remove(object);
        }
    }

    /**
     * Draw all game objects:
     * a) fill the entire canvas with periods.
     * b) draw all the objects on the canvas.
     */
    public void draw(Canvas canvas) {
        // Draw the game
        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                canvas.setPoint(i, j, '.');
            }
        }

        for (int i = 0; i < width + 2; i++) {
            canvas.setPoint(i, 0, '-');
            canvas.setPoint(i, height + 1, '-');
        }

        for (int i = 0; i < height + 2; i++) {
            canvas.setPoint(0, i, '|');
            canvas.setPoint(width + 1, i, '|');
        }

        for (BaseObject object : getAllItems()) {
            object.draw(canvas);
        }
    }


    public Spaceship getShip() {
        return ship;
    }

    public void setShip(Spaceship ship) {
        this.ship = ship;
    }

    public List<Ufo> getUfos() {
        return ufos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public List<Rocket> getRockets() {
        return rockets;
    }

    public static Space game;

    public static void main(String[] args) throws Exception {
        game = new Space(20, 20);
        game.setShip(new Spaceship(10, 18));
        game.run();
    }

    /**
     * The method pauses for delay seconds.
     */
    public static void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }
}