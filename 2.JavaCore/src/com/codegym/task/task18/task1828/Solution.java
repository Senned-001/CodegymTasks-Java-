package com.codegym.task.task18.task1828;

/* 
Prices 2

*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        if (args.length > 0) {
            ArrayList<String> text = new ArrayList<>();
            BufferedReader bufr = new BufferedReader(new FileReader(name));
            if (args[0].equals("-u")) {

                String s = bufr.readLine();
                while (s != null) {
                    String ind = s.substring(0, 8);
                    String arg=args[1];
                    if (arg.contains(" "))
                        arg = arg.substring(0, arg.indexOf(" "));
                    if (ind.contains(" "))
                        ind = ind.substring(0, ind.indexOf(" "));       //remove space if it has
                    if (arg.equals(ind)) {
                        String new_prod = args[2];
                        String new_price = args[3];
                        String new_q = args[4];
                        while (new_prod.toCharArray().length < 30) {
                            new_prod = new_prod + " ";
                        }
                        while (new_price.toCharArray().length < 8) {
                            new_price = new_price + " ";
                        }
                        while (new_q.toCharArray().length < 4) {
                            new_q = new_q + " ";
                        }
                        String data = s.substring(0, 8) + new_prod + new_price + new_q;
                        text.add(data);
                    } else
                        text.add(s);
                    s = bufr.readLine();
                }
                bufr.close();

                BufferedWriter bufw = new BufferedWriter(new FileWriter(name));
                for (int i = 0; i < text.size(); i++) {
                    bufw.write(text.get(i)+"\n");
                    bufw.flush();
                }
                bufw.close();
            }

            if (args[0].equals("-d")){
                String s = bufr.readLine();
                while (s != null) {
                    String ind = s.substring(0, 8);
                    String arg=args[1];
                    if (arg.contains(" "))
                        arg = arg.substring(0, arg.indexOf(" "));
                    if (ind.contains(" "))
                        ind = ind.substring(0, ind.indexOf(" "));       //remove space if it has
                    if (!arg.equals(ind))
                        text.add(s);
                    s = bufr.readLine();
                }
                bufr.close();

                BufferedWriter bufw = new BufferedWriter(new FileWriter(name));
                for (int i = 0; i < text.size(); i++) {
                    bufw.write(text.get(i)+"\n");
                    bufw.flush();
                }
                bufw.close();
            }
        }
    }
}
