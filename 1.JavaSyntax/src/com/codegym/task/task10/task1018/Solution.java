package com.codegym.task.task10.task1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Corrections are needed

*/

public class Solution {
    HashMap<Integer, String> map;
    static Integer index;
    static String name;

    public Solution() {
        this.map = new HashMap<Integer, String>();
        //map.put(index, name);
    }

    public void puttomap(int index,String name){
        this.map.put(index,name);
    }
    
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int index = Integer.parseInt(reader.readLine());
            String name = reader.readLine();
            solution.puttomap(index, name);
        }

        for (Map.Entry<Integer, String> pair : solution.map.entrySet()) {
            index = pair.getKey();
            name = pair.getValue();
            System.out.println("Id=" + index + " Name=" + name);
        }
    }
}
