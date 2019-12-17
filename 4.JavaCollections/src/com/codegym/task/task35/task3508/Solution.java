package com.codegym.task.task35.task3508;

import java.util.List;

/* 
extends vs super

*/
public abstract class Solution {
    public abstract <T> void methodOne(List<T> destination, List<T> source);

    public abstract <T> void methodTwo(List<T> destination, List<? extends T> source);

    public abstract <T> void methodThree(List<? super T> destination, List<T> source);

    public abstract <T> void methodFour(List<? super T> destination, List<? extends T> source);
}