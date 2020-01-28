package com.codegym.task.task15.task1505;

import java.util.ArrayList;
import java.util.List;

/* 
OOP: Fix inheritance problems

*/

public class Solution {
    public static interface LivingPart {
        Object containsBones();
    }

    public static class BodyPart implements LivingPart {
        private String name;

        public BodyPart(String name) {
            this.name = name;
        }

        @Override
        public Object containsBones() {
            return "Yes";
        }

        @Override
        public String toString() {
            if(containsBones().equals("Yes"))
                return name + " contains bones";
            else
                return name + " does not contain bones";
        }
    }

    public static class Finger extends BodyPart {
        private boolean isArtificial;

        public Finger(String name, boolean isArtificial) {
            super(name);
            this.isArtificial = isArtificial;
        }

        @Override
        public Object containsBones() {
            if (super.containsBones().equals("Yes")&&!isArtificial) return "Yes";
            else return "No";
            /*return this;super.containsBones() && !isArtificial;*/
        }
    }

    public static void main(String[] args) {
        printlnFingers();
        printlnBodyParts();
        printlnLivingParts();
    }

    private static void printlnLivingParts() {
        System.out.println(new BodyPart("Hand").containsBones());
    }

    private static void printlnBodyParts() {
        List<BodyPart> bodyParts = new ArrayList<BodyPart>(5);
        bodyParts.add(new BodyPart("Hand"));
        bodyParts.add(new BodyPart("Leg"));
        bodyParts.add(new BodyPart("Head"));
        bodyParts.add(new BodyPart("Body"));
        System.out.println(bodyParts.toString());
    }

    private static void printlnFingers() {
        List<Finger> fingers = new ArrayList<Finger>(5);
        fingers.add(new Finger("Thumb", true));
        fingers.add(new Finger("Forefinger", true));
        fingers.add(new Finger("Middle finger", true));
        fingers.add(new Finger("Ring-finger", false));
        fingers.add(new Finger("Pinky", true));
        System.out.println(fingers.toString());
    }
}

