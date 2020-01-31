package com.codegym.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD

*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) throws Exception {
        // Start here
       /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String [] args = name.split(" ");*/
        if (args.length != 0) {
            if (args[0].equals("-c")) {
                SimpleDateFormat datein = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
                //String d = args[3] + " " + args[4] + " " + args[5];
                //d = d.substring(1, d.length() - 1);
                if (args[2].equals("m"))
                    allPeople.add(Person.createMale(args[1], datein.parse(args[3])));
                else
                    allPeople.add(Person.createFemale(args[1], datein.parse(args[3])));
                System.out.println(allPeople.size() - 1);
            }
            if (args[0].equals("-u")) {
                SimpleDateFormat datein = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
                //String d = args[4] + " " + args[5] + " " + args[6];
                //d = d.substring(1, d.length() - 1);
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                if (args[3].equals("m"))
                    allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
                else
                    allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(datein.parse(args[4]));
            }
            if (args[0].equals("-d")) {
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);

            }
            if (args[0].equals("-i")) {
                SimpleDateFormat dateout = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
                System.out.print(allPeople.get(Integer.parseInt(args[1])).getName() + " ");
                if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE))
                    System.out.print("m " + dateout.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
                else
                    System.out.print("f " + dateout.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
            }
        }
    }
}
