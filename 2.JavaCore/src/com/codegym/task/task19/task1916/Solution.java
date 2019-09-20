package com.codegym.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Tracking changes

*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

       /*  BufferedReader read1f = new BufferedReader(new FileReader(name1));

        String data1="";
        while ((data1=read1f.readLine())!=null){
            lines.add(new LineItem(Type.REMOVED,data1));
        }

        read1f.close();
        BufferedReader read2f = new BufferedReader(new FileReader(name2));
        String data2="";
        while ((data2=read2f.readLine())!=null){
            for(int i=0;i<lines.size();i++){
                if(data2.equals(lines.get(i).line)) {
                    lines.get(i).type=Type.SAME;
                    lines.get(i).line="SAME "+lines.get(i).line;
                }
                else {
                    lines.add(new LineItem(Type.ADDED,"ADDED "+data2));

                }
            }

        }


        read2f.close();
        for(int i=0;i<lines.size();i++){
            if(lines.get(i).type==Type.REMOVED) lines.get(i).line="REMOVED "+lines.get(i).line;
        }


 */  //  sohranenie pamyati no validator zabril

        ArrayList<String> sp = new ArrayList<>();
        ArrayList<String> sp2= new ArrayList<>();
        BufferedReader read1f = new BufferedReader(new FileReader(name1));
        BufferedReader read2f = new BufferedReader(new FileReader(name2));
        String data1="";
        String data2="";
        while ((data1=read1f.readLine())!=null){
            sp.add(data1);
        }

        read1f.close();

        while ((data2=read2f.readLine())!=null){
            sp2.add(data2);
        }

        read2f.close();



            //for(int i=0;i<sp2.size();i++) {

            while(!sp2.isEmpty()){
                if((sp.isEmpty())){ //esli fail 2 bolche
                    lines.add(new LineItem(Type.ADDED, sp2.get(0)));
                    sp2.remove(0);
                }
                else if (sp2.get(0).equals(sp.get(0))) {
                    lines.add(new LineItem(Type.SAME, sp2.get(0)));
                    sp.remove(0);
                    sp2.remove(0);
                } else if (sp2.get(0).equals(sp.get(1))) {
                    lines.add(new LineItem(Type.REMOVED, sp.get(0)));
                    sp.remove(0);
                } else if (sp2.get(1).equals(sp.get(0))) {
                    lines.add(new LineItem(Type.ADDED, sp2.get(0)));
                    sp2.remove(0);
                }

            }


        while(!sp.isEmpty()){ //esli fail odin bolche
            lines.add(new LineItem(Type.REMOVED, sp.get(0)));
            sp.remove(0);
        }


    }

    public static enum Type {
        ADDED,        // New line added
        REMOVED,      // Line deleted
        SAME          // No change
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
