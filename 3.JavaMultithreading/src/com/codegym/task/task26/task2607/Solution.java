package com.codegym.task.task26.task2607;

/* 
Politeness is an artificial good mood

*/
public class Solution {

    public static class IntegerHolder{
        private int value;


        synchronized public int get(){
            return this.value;
        }
        synchronized public void set(int val){
            this.value=val;
        }

    }


    public static void main(String[] args) {
    }
}
