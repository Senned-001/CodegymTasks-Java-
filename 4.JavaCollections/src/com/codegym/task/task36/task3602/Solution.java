package com.codegym.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Find the class by its description

*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] clazz = Collections.class.getDeclaredClasses();
        for(Class<?> c :clazz){

           // Class<?>[] interfaces = c.getInterfaces();
            //for(Class<?> i :interfaces) {
                //if (i==List.class) {
            if(List.class.isAssignableFrom(c)&&Modifier.isPrivate(c.getModifiers()) && Modifier.isStatic(c.getModifiers())){

                        Method method = null;
                        Constructor constructor = null;
                        try {
                            method = c.getDeclaredMethod("get", int.class);
                            method.setAccessible(true);
                            constructor = c.getDeclaredConstructor();
                            constructor.setAccessible(true);
                        } catch (NoSuchMethodException e) {
                            continue;
                        }

                        try {
                            method.invoke(constructor.newInstance(), 5);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            if (e.getCause().toString().contains("IndexOutOfBoundsException")) return c;
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
            }

        }
        return null;
    }
}
