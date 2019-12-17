package com.codegym.task.task35.task3512;

import java.lang.reflect.InvocationTargetException;

public class Generator<T> {
    private Class<T> clazz;

    public Generator(Class<T> classname) {
        this.clazz = classname;
    }

    T newInstance() throws InstantiationException, IllegalAccessException{

        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            return null;
        } catch (NoSuchMethodException e) {
            return null;
        }

    }
}
