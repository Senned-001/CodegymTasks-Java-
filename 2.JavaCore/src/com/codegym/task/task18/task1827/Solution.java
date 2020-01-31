package com.codegym.task.task18.task1827;

/* 
Prices

*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        if (args.length > 0) {
            if (args[0].equals("-c")) {
                //ArrayList<String> text = new ArrayList<>();
                BufferedReader bufr = new BufferedReader(new FileReader(name));
                int last_id = 0;
                String s = bufr.readLine();
                while (s != null) {
                    String ind=s.substring(0, 8);
                    if(ind.contains(" ")) ind=ind.substring(0, ind.indexOf(" "));       //ubiraem probeli esli est
                    if (last_id < Integer.parseInt(ind)) last_id = Integer.parseInt(ind);
                    //text.add(s);
                    s = bufr.readLine();
                }
                bufr.close();
                last_id = last_id + 1;

                String new_id = "" + last_id;
                String new_prod = args[1];
                String new_price = args[2];
                String new_q = args[3];

                while (new_id.toCharArray().length < 8) {
                    new_id = new_id + " ";
                }
                while (new_prod.toCharArray().length < 30) {
                    new_prod = new_prod + " ";
                }
                while (new_price.toCharArray().length < 8) {
                    new_price = new_price + " ";
                }
                while (new_q.toCharArray().length < 4) {
                    new_q = new_q + " ";
                }
                String data = "\n" + new_id + new_prod + new_price + new_q;
                BufferedWriter bufw = new BufferedWriter(new FileWriter(name,true));
                /*for (int i = 0; i < text.size(); i++) {
                    bufw.write(text.get(i));
                    bufw.flush();
                }*/
                bufw.write(data);
                bufw.flush();
                bufw.close();
            }
        }
    }
}
