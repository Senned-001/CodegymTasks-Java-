package com.codegym.task.task23.task2312;

public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }


    public static Room game;

    public static void main(String[] args) {
        Snake newsnake=new Snake(10,10);
        game=new Room(100,100,newsnake);
        newsnake.setDirection(SnakeDirection.DOWN);
    }

    public void run(){

    }
    public void print(){

    }
    public void createMouse(){
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);
        this.setMouse(new Mouse(x,y));
    }

    public void eatMouse(){
        createMouse();
    }
}
