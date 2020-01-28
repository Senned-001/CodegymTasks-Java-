package com.codegym.task.task10.task1013;

/* 
Human class constructors

*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String lastname;
        private boolean sex;
        private int age;
        private int weigh;
        private String prof;

        public Human (String name){
            this.name = name;
        }

        public Human (String name,String lastname){
            this.name = name;
            this.lastname=lastname;
        }

        public Human (String name,String lastname,boolean sex){
            this.name = name;
            this.lastname=lastname;
            this.sex=sex;
        }

        public Human (String name,String lastname,boolean sex,int age){
            this.name = name;
            this.lastname=lastname;
            this.sex=sex;
            this.age=age;
        }

        public Human (String name,String lastname,boolean sex,int age, int weigh){
            this.name = name;
            this.lastname=lastname;
            this.sex=sex;
            this.age=age;
            this.weigh=weigh;
        }

        public Human (String name,String lastname,boolean sex,int age, int weigh, String prof){
            this.name = name;
            this.lastname=lastname;
            this.sex=sex;
            this.age=age;
            this.weigh=weigh;
            this.prof=prof;
        }

        public Human (String name,String lastname, String prof){
            this.name = name;
            this.lastname=lastname;
            this.prof=prof;
        }

        public Human (String name, boolean sex){
            this.name = name;
            this.sex=sex;
        }

        public Human (String name,int age){
            this.name = name;
            this.age=age;
        }

        public Human (String name, boolean sex, int age){
            this.name = name;
            this.sex=sex;
            this.age=age;
        }
    }
}
