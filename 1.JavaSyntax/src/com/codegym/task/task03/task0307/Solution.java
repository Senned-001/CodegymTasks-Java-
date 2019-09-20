package com.codegym.task.task03.task0307;

/* 
Hello, StarCraft!

*/

public class Solution {
    public static void main(String[] args) {
        Zerg z1 = new Zerg();
        z1.name = "zz1";
        Zerg z2 = new Zerg();
        z2.name = "zz2";
        Zerg z3 = new Zerg();
        z3.name = "zz3";
        Zerg z4 = new Zerg();
        z4.name = "zz4";
        Zerg z5 = new Zerg();
        z5.name = "zz5";

        Protoss p1 = new Protoss();
        p1.name = "pp1";
        Protoss p2 = new Protoss();
        p2.name = "pp2";
        Protoss p3 = new Protoss();
        p3.name = "pp3";

        Terran t1 = new Terran();
        t1.name = "tt1";
        Terran t2 = new Terran();
        t2.name = "tt2";
        Terran t3 = new Terran();
        t3.name = "tt3";
        Terran t4 = new Terran();
        t4.name = "tt4";
    }


    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
