package com.codegym.task.task18.task1825;

import java.io.*;
import java.util.*;

/* File file = new File("
Building a file

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> names = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String name = reader.readLine();
            if (name.equals("end")) break;
            else {
                names.add(name);
                //names.add(Integer.parseInt(name.split(".part")[1]) - 1, name); //dobavlyaem v sootvetstvii s idexom-1
            }
        }
        reader.close();
        File file = new File(names.get(0).split(".part")[0]);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        ArrayList<BufferedReader> bufs=new ArrayList<>();
        for(int i=0;i<names.size();i++){
            bufs.add(i,new BufferedReader(new FileReader(names.get(i).split(".part")[0]+".part"+(i+1))));
            String data = bufs.get(i).readLine();
            while(data!=null){
                bw.write(data);
                bw.flush();
                data = bufs.get(i).readLine();
            }
            bufs.get(i).close();
        }
        bw.close();
    }
}
