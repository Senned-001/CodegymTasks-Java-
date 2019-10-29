package com.codegym.task.task26.task2603;

import java.util.Collections;
import java.util.Comparator;

/*
A convert can easily convert others

*/
public class Solution {

    public static class CustomizedComparator<T>implements Comparator<T>{
        private Comparator<T>[] comparators;

        @Override
        public int compare(T o1, T o2) {

            for (Comparator<T> x:comparators ) {
                int temp=x.compare(o1, o2);
                if(temp!=0) return temp;
            }
            return 0;
        }



        public CustomizedComparator(Comparator<T>...comp) {
            this.comparators = comp;
        }
    }


    public static void main(String[] args) {

    }
}
