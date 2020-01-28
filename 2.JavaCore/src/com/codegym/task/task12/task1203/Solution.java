package com.codegym.task.task12.task1203;

/* 
Render to Caesar the things that are Caesar's

*/

public class Solution {
    public static void main(String[] args) {
        Pet pet1 = new Cat();
        Pet cat = pet1.getChild();
        Pet pet2 = new Dog();
        Pet dog = pet2.getChild();
    }

    public static class Pet {
        public Pet getChild() {
            return new Pet();
        }
    }

    public static class Cat extends Pet {
        public Pet getChild() {
            return new Cat();
        }
    }

    public static class Dog extends Pet {
        public Pet getChild() {
            return new Dog();
        }
    }
}
