package com.codegym.task.task14.task1404;

/* 
Cats

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Cat c=null;
        while(true){
        String name1 = reader.readLine();
        if(name1.equals("")) break;
        else  {c=CatFactory.getCatByKey(name1);
            System.out.println(c.toString());}
        }
        reader.close();
    }

    static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat = null;
            if ("boss".equals(key)) {
                cat = new MaleCat("Big Boy");
            } else if ("miss".equals(key)) {
                cat = new FemaleCat("Missy");
            } else if ("smudge".equals(key)) {
                cat = new FemaleCat("Smudgey");
            } else {
                cat = new Cat(key);
            }
            return cat;
        }
    }

    static class Cat {
        private String name;

        protected Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return "I'm " + getName() + ", an alley cat";
        }
    }

    static class MaleCat extends Cat {
        MaleCat(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "I'm a cat powerhouse named " + getName();
        }
    }

    static class FemaleCat extends Cat {
        FemaleCat(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "I'm a cute kitty named " + getName();
        }
    }
}
