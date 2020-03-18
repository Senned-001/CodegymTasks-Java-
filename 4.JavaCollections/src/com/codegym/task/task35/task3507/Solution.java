package com.codegym.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
What is ClassLoader?

*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> result=new HashSet<>();
        File[] files = new File(pathToAnimals).listFiles();
        ClassLoader classLoader=new MyClassLoader();
        for(File f:files) {
            if (f.getName().endsWith(".class")) {
                try {
                    Class s = ((MyClassLoader) classLoader).findClass(f.getAbsolutePath());
                    result.add((Animal) s.getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    continue;
                }
            }
        }
        return result;
    }

     static class MyClassLoader extends ClassLoader{
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            byte[] bytes = new byte[0];
            try {
                bytes = Files.readAllBytes(Paths.get(name));
            } catch (IOException e) {
            }
            Class<?> cl = defineClass(null, bytes, 0, bytes.length);
            return cl;
        }
    }
}
