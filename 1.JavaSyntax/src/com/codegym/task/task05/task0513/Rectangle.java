package com.codegym.task.task05.task0513;

/* 
Let's put together a rectangle

*/

public class Rectangle {
    int top, left, width =0, height= 0;

    public void initialize(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height=height;
    }

    public void initialize(int top, int left) {
        this.top = top;
        this.left = left;
    }

    public void initialize(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height=width;
    }

    public void initialize(Rectangle a) {
        this.top = a.top;
        this.left = a.left;
        this.width = a.width;
        this.height=a.height;
    }




    public static void main(String[] args) {

    }
}
