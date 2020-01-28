package com.codegym.task.task13.task1310;

/* 
Who's that smarty?

*/

public class Solution {
    public static void main(String[] args) {
    }

    interface Person {

        void use(Person person);

        void startToWork();
    }

    interface CanWork {
        boolean wantsToGetExtraWork();
    }

    interface Secretary extends Person{
    }

    interface Boss extends Person, CanWork{
    }

    class CleverMan implements Boss {

        @Override
        public void use(Person person) {
            person.startToWork();
        }

        @Override
        public void startToWork() {
        }

        public boolean wantsToGetExtraWork() {
            return true;
        }
    }

    class SmartGirl implements Secretary{

        @Override
        public void use(Person person) {
        }

        @Override
        public void startToWork() {
        }
    }
}
