package com.codegym.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* 
Compare modifiers


info
bin name                dec
 1 public               1
 10 PRIVATE             2
 100 PROTECTED          4
 1000 static            8
 10000 final            16
 100000 SYNCHRONIZED    32
 1000000 VOLATILE       64
 10000000 TRANSIENT     128
 100000000 NATIVE       256
 1000000000 INTERFACE   512
 10000000000 ABSTRACT   1024
 100000000000 STRICT    2048
*/
public class Solution {
    public static void main(String[] args) {
        int classModifiers = Solution.class.getModifiers();
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();                 //return main(public static)
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));  //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        String mod=Integer.toBinaryString(allModifiers);
        ArrayList<Integer> modif=new ArrayList();

        for(int i=mod.length()-1;i>=0;i--){
            if(mod.charAt(i)=='1'&&i==0) modif.add(Modifier.PUBLIC);
            if(mod.charAt(i)=='1'&&i==1) modif.add(Modifier.PRIVATE);
            if(mod.charAt(i)=='1'&&i==2) modif.add(Modifier.PROTECTED);
            if(mod.charAt(i)=='1'&&i==3) modif.add(Modifier.STATIC);
            if(mod.charAt(i)=='1'&&i==4) modif.add(Modifier.FINAL);
            if(mod.charAt(i)=='1'&&i==5) modif.add(Modifier.SYNCHRONIZED);
            if(mod.charAt(i)=='1'&&i==6) modif.add(Modifier.VOLATILE);
            if(mod.charAt(i)=='1'&&i==7) modif.add(Modifier.TRANSIENT);
            if(mod.charAt(i)=='1'&&i==8) modif.add(Modifier.NATIVE);
            if(mod.charAt(i)=='1'&&i==9) modif.add(Modifier.INTERFACE);
            if(mod.charAt(i)=='1'&&i==10) modif.add(Modifier.ABSTRACT);
            if(mod.charAt(i)=='1'&&i==11) modif.add(Modifier.STRICT);
        }

        if(modif.contains(specificModifier))
            return true;
        else
            return false;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main"))
                return method;
        }
        return null;
    }
}
