package com.codegym.task.task05.task0520;

/* 
Create a Rectangle class

*/


public class Rectangle {
    int top, left, width =0, height= 0;

    public Rectangle(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height=height;
    }

    public Rectangle(int top, int left) {
        this.top = top;
        this.left = left;
    }

    public Rectangle(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height=width;
    }

    public Rectangle(Rectangle a) {
        this.top = a.top;
        this.left = a.left;
        this.width = a.width;
        this.height=a.height;
    }
    public static void main(String[] args) {

    }
}
