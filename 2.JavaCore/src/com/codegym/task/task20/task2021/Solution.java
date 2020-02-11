package com.codegym.task.task20.task2021;

import java.io.*;

/* 
Serialization is prohibited

*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {

        public void writeObject(ObjectOutputStream out) throws Exception {
            throw new NotSerializableException();
        }


        public void readObject(ObjectInputStream in) throws Exception {
            throw new NotSerializableException();
        }

    }
    public static void main(String[] args) {
    }
}
