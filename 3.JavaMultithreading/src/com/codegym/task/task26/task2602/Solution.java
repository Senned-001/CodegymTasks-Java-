package com.codegym.task.task26.task2602;

import java.util.Set;
import java.util.TreeSet;

/* 
Think and you will succeed

*/
public class Solution {
    public static void main(String[] args) {
        Set<Soldier> soldiers = new TreeSet<>();
        soldiers.add(new Soldier("Johnson", 170));
        soldiers.add(new Soldier("Gates", 180));
        soldiers.add(new Soldier("Jones", 175));

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.name);
        }
    }

    public static class Soldier implements Comparable<Soldier> {
        private String name;
        private int height;

        public Soldier(String name, int height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(Soldier soldier) {
            return soldier.height-this.height;
        }
    }
}
