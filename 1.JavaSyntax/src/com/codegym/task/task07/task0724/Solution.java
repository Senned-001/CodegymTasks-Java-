package com.codegym.task.task07.task0724;

/* 
Family census

*/

public class Solution {
    public static void main(String[] args) {
        Human old1 = new Human("old1",true,75);
        Human old2 = new Human("old2",true,78);
        Human old3 = new Human("old3",false,72);
        Human old4 = new Human("old4",false,71);

        Human young1 = new Human("young1",true,45,old1,old3);
        Human young2 = new Human("young2",true,40,old2,old4);
        Human young3 = new Human("young3",false,33,young1, young2);
        Human young4 = new Human("young4",false,31,young1, young2);
        Human young5 = new Human("young5",false,27,young1, young2);

        System.out.println(old1.toString());
        System.out.println(old2.toString());
        System.out.println(old3.toString());
        System.out.println(old4.toString());
        System.out.println(young1.toString());
        System.out.println(young2.toString());
        System.out.println(young3.toString());
        System.out.println(young4.toString());
        System.out.println(young5.toString());

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father, mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father=father;
            this.mother=mother;
        }

        public String toString() {
            String text = "";
            text += "Name: " + this.name;
            text += ", sex: " + (this.sex ? "male" : "female");
            text += ", age: " + this.age;

            if (this.father != null)
                text += ", father: " + this.father.name;

            if (this.mother != null)
                text += ", mother: " + this.mother.name;

            return text;
        }
    }
}