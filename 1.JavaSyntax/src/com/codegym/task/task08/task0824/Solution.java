package com.codegym.task.task08.task0824;

/* 
Make a family

*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        Human ch1 = new Human();
        ch1.name = "ch1";
        ch1.sex = true;
        ch1.age = 12;
        Human ch2 = new Human();
        ch2.name = "ch2";
        ch2.sex = false;
        ch2.age = 8;
        Human ch3 = new Human();
        ch3.name = "ch3";
        ch3.sex = true;
        ch3.age = 15;

        Human p1 = new Human();
        p1.name = "p1";
        p1.sex = true;
        p1.age = 45;
        p1.children.add(ch1);
        p1.children.add(ch2);
        p1.children.add(ch3);
        Human p2 = new Human();
        p2.name = "p1";
        p2.sex = false;
        p2.age = 40;
        p2.children.add(ch1);
        p2.children.add(ch2);
        p2.children.add(ch3);

        Human gf1 = new Human();
        gf1.name = "gf1";
        gf1.sex = true;
        gf1.age = 78;
        gf1.children.add(p1);
        Human gm1 = new Human();
        gm1.name = "gm1";
        gm1.sex = false;
        gm1.age = 75;
        gm1.children.add(p1);

        Human gf2 = new Human();
        gf2.name = "gf2";
        gf2.sex = true;
        gf2.age = 80;
        gf2.children.add(p2);
        Human gm2 = new Human();
        gm2.name = "gm2";
        gm2.sex = false;
        gm2.age = 74;
        gm2.children.add(p2);

        System.out.println(ch1.toString());
        System.out.println(ch2.toString());
        System.out.println(ch3.toString());
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(gf1.toString());
        System.out.println(gm1.toString());
        System.out.println(gf2.toString());
        System.out.println(gm2.toString());
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public String toString() {
            String text = "";
            text += "Name: " + this.name;
            text += ", sex: " + (this.sex ? "male" : "female");
            text += ", age: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", children: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
