package com.codegym.task.task20.task2018;

import java.io.*;

/* 
Find the bugs

*/
public class Solution implements Serializable{
    public static class A {

        protected String nameA = "A";

        public A(String nameA) {
            this.nameA += nameA;
        }

        public A(){}
    }

    public class B extends A implements Serializable {
        //private String nameA;
        private String nameB;

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(super.nameA);
        }

        private void readObject(ObjectInputStream in)throws IOException,ClassNotFoundException{

            in.defaultReadObject();
            super.nameA = (String )in.readObject();

        }
    }






    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);
        //b.writeObject(oos);     //overrating metods, but don't use them, why?


        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B)ois.readObject();
        //B b1=solution.new B(null,null);
        //b1.readObject(ois);           //overrating metods, but don't use them, why? upd:it callings but not direct
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}
