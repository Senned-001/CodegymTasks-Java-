package com.codegym.task.task05.task0527;

/* 
Tom and Jerry

*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Cat TomCat = new Cat("Tom", 52, 10);
        Dog BusterDog = new Dog("Buster",100,50);
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

        public static class Cat {
            String name;
            int height;
            int tail;

            public Cat(String name, int height, int tail) {
                this.name = name;
                this.height = height;
                this.tail = tail;
            }
        }
        public static class Dog {
            String name;
            int height;
            int tail;

            public Dog(String name, int height, int tail) {
                this.name = name;
                this.height = height;
                this.tail = tail;
            }
        }
    }

