package com.codegym.task.task17.task1713;

import java.util.*;

/* 
Shared list

*/

public class Solution implements List<Long> {
    private ArrayList<Long> original = new ArrayList<>();

    @Override
    public synchronized int indexOf(Object a){
        return original.indexOf(a);
    }

    @Override
    public synchronized int lastIndexOf(Object a){
        return original.lastIndexOf(a);
    }
    @Override
    public synchronized ListIterator<Long> listIterator(){
        return original.listIterator();
    }
    @Override
    public synchronized ListIterator<Long> listIterator(int a){
        return original.listIterator(a);
    }
    @Override
    public synchronized int size(){
        return original.size();
    }

    @Override
    public synchronized List<Long> subList(int a, int b){
        return original.subList(a,b);
    }

    @Override
    public synchronized boolean isEmpty(){
        return original.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object s){
        return original.contains(s);
    }

    @Override
    public synchronized Iterator iterator() {
        return original.iterator();
    }
    @Override
    public synchronized Object[] toArray(){
        return original.toArray();
    }
    @Override
    public synchronized Object[] toArray(Object[] s){
        return original.toArray(s);
    }
    @Override
    public synchronized boolean add(Long a){
        return original.add(a);
    }
    @Override
    public synchronized void add(int c, Long a){
        original.add(c,a);
    }
    @Override
    public synchronized Long remove(int a){
        return original.remove(a);
    }
    @Override
    public synchronized boolean remove(Object a) {
        return original.remove(a);
    }
    @Override
    public synchronized boolean containsAll(Collection a){
        return original.containsAll(a);
    }
    @Override
    public synchronized boolean addAll(Collection a){
        return original.addAll(a);
    }

    @Override
    public synchronized boolean addAll(int a, Collection b){
        return original.addAll(a,b);
    }
    @Override
    public synchronized boolean removeAll(Collection b) {
        return original.removeAll(b);
    }
    @Override
    public synchronized boolean retainAll(Collection b) {
        return original.retainAll(b);
    }
    @Override
    public synchronized void clear() {
        original.clear();
    }
    @Override
    public synchronized Long get(int a){
        return original.get(a);
    }

    public synchronized Long set(int i, Long a){
        return original.set(i, a);
    }

    public static void main(String[] args) {

    }
}
