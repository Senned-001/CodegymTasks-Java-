package com.codegym.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Mastering ClassLoader and Reflection

*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/codegym/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File file=new File(packageName);
        File[]files=file.listFiles();
        ClassLoader classLoader=new MyClassLoader();
        for(File f:files){
            if(f.getName().endsWith(".class"))
                hiddenClasses.add(((MyClassLoader) classLoader).findClass(f.getAbsolutePath()));

        }

    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for(Class c:hiddenClasses){
            if(c.getSimpleName().toLowerCase().startsWith(key.toLowerCase()))
                try {
                    Constructor constr=c.getDeclaredConstructor();

                    constr.setAccessible(true);
                    return (HiddenClass)constr.newInstance();
                } catch (Exception e) {
                    return null;
                }
        }
        return null;
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
