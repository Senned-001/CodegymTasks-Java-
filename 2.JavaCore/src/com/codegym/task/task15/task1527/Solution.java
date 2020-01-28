package com.codegym.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Request parser

*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        reader.close();
        //reduce string for param (after ?)
        String parametrs=null;
        for(int i=0;i<name1.length();i++){
            if(name1.charAt(i)=='?') {
                parametrs=name1.substring(i+1,name1.length());
                break;
            }
        }
        //init array of param par=a
        ArrayList<String> list=new ArrayList<>();
        String s="";
        String k="";
        String v="";
        for(int i=0;i<parametrs.length();i++){
            if(parametrs.charAt(i)=='&') {
                list.add(s);
                s="";
            }
            else if(i+1==parametrs.length()){
                s=s+parametrs.charAt(i);
                list.add(s);
            }
            else{
                s=s+parametrs.charAt(i);
            }
        }
        //init hashmap by values k=v
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        for (String x: list) {
            if(x.contains("=")) {
                int i=0;
                while(x.charAt(i)!='='){
                    k=k+x.charAt(i);
                    i++;
                }
                i++;
                while(i!=x.length()){
                    v=v+x.charAt(i);
                    i++;
                }
                map.put(k,v);
                k="";
                v="";
            }
            else{
                map.put(x,"");
            }
        }
        int count=0;
        //print with iterator without last space-" "
        Set entrySet = map.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            if(me.getKey().equals("obj"))
                count++;
            if(it.hasNext())
                System.out.print(me.getKey()+" ");
            else
                System.out.print(me.getKey());
        }
        //if object founded try to parse to Double
        if ((count>0)) {
            System.out.println();
            Double d = 0.0;
            try {
                d = Double.parseDouble(map.get("obj"));
                alert(d);
            } catch (NumberFormatException e) {
                alert(map.get("obj"));
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
