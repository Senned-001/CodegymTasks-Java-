package com.codegym.task.task35.task3503;

/* 
Several superclasses for generics

*/
public class Solution<T extends ClassForGenerics&InterfaceForGenerics> {
    public static void main(String[] args) {
        Solution<GoodTestClass> testSolution = new Solution<>();
        testSolution.check();

        // !!! Both of the following options should not work. Comment them out:
        /*Solution<BadTestClass1> badSolution1 = new Solution<>();
        badSolution1.check();
        Solution<BadTestClass2> badSolution2 = new Solution<>();
        badSolution2.check();*/
    }

    public void check() {
        System.out.println("It works!");
    }

    public static class GoodTestClass extends ClassForGenerics implements InterfaceForGenerics {

    }

    public static class BadTestClass1 extends ClassForGenerics {

    }

    public static class BadTestClass2 implements InterfaceForGenerics {
    }
}