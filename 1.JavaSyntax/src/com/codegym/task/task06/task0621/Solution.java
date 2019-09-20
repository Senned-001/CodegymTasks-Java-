package com.codegym.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Cat relations

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandfatherName = reader.readLine();
        Cat grandfather = new Cat(grandfatherName);
        String grandmotherName = reader.readLine();
        Cat grandmother = new Cat(grandmotherName);

        String fatherName = reader.readLine();
        Cat father = new Cat(fatherName, null, grandfather);
        String motherName = reader.readLine();
        Cat mother = new Cat(motherName, grandmother, null);

        String sonName = reader.readLine();
        Cat son = new Cat(sonName, mother, father);
        String daughterName = reader.readLine();
        Cat daughter = new Cat(daughterName,  mother, father);

        System.out.println(grandfather.toString());
        System.out.println(grandmother.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(son.toString());
        System.out.println(daughter.toString());
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }



        @Override
        public String toString() {
            if ((father == null)&&(mother == null))
                return "The cat's name is " + name + ", no mother, no father";
            else if ((father == null)&&(mother != null))
                return "The cat's name is " + name + ", " + mother.name + " is the mother, no father";
            else if ((father != null)&&(mother == null))
                return "The cat's name is " + name + ", no mother, "+ father.name + " is the father";
            else
                return "The cat's name is " + name + ", " + mother.name + " is the mother, "+ father.name + " is the father";
        }
    }

}
