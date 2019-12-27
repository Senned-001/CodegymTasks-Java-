package com.codegym.task.task37.task3701;

import java.util.*;
import java.util.function.Consumer;

/* 
Circular iterator

*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularIterator();
    }

    public class CircularIterator implements Iterator<T>{
        ListIterator<T> it = Solution.super.listIterator();     //get the listiterator for Arraylist class
        @Override
        public boolean hasNext() {
            if(!it.hasNext()) it = Solution.super.listIterator();   //get new iterator if it last element
            return it.hasNext();
        }

        @Override
        public T next() {
            return it.next();
        }

        @Override
        public void remove() {
            it.remove();
        }
    }
}
