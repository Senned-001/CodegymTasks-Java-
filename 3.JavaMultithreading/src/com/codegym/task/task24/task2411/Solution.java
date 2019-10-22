package com.codegym.task.task24.task2411;

/* 
Let's recall inheritance

*/
public class Solution extends C{
    private class A {
        protected String value = "A";

        public A() {
            System.out.print(value);
        }
    }

    private A a = new A() {
        { // Anonymous classes don't have their own constructors, but you can do something in the class's initialization block
            value = "Y";
            if (super.getClass().getName().contains(".Solution$")) {
                System.out.print(value);
            }
        }
    };

    public Solution() {
        System.out.print("S");
    }

    public static void main(String[] args) {
        new Solution();
    }
}



