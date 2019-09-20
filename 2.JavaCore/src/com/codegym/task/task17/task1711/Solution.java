package com.codegym.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2

*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) throws  Exception{
        // Start here
        if (args.length != 0) {
            SimpleDateFormat datein = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);//parametr vnosimoy dati
            SimpleDateFormat dateout = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);//parametr vivodimoy dati

            switch (args[0]){                   //realizaciya cherz switch

                case "-c":                       //-c
                for(int i=0;i<(args.length-1);i=i+3) { //shag raven kol-vu argumentov
                    if (args[i+2].equals("m")) allPeople.add(Person.createMale(args[i+1], datein.parse(args[i+3])));
                    else allPeople.add(Person.createFemale(args[i+1], datein.parse(args[i+3])));
                    System.out.println(allPeople.size() - 1);
                }
                break;

                case "-u":                       //-u
                for(int i=0;i<(args.length-1);i=i+4) {
                    allPeople.get(Integer.parseInt(args[i+1])).setName(args[i+2]);
                    if (args[i+3].equals("m")) allPeople.get(Integer.parseInt(args[i+1])).setSex(Sex.MALE);
                    else allPeople.get(Integer.parseInt(args[i+1])).setSex(Sex.FEMALE);
                    allPeople.get(Integer.parseInt(args[i+1])).setBirthDate(datein.parse(args[i+4]));
                }
                break;

                case "-d":                       //-d
                for(int i=0;i<(args.length-1);i++) {
                    allPeople.get(Integer.parseInt(args[i+1])).setName(null);
                    allPeople.get(Integer.parseInt(args[i+1])).setSex(null);
                    allPeople.get(Integer.parseInt(args[i+1])).setBirthDate(null);
                }
                break;

                case "-i":                        //-i
                for(int i=0;i<(args.length-1);i++) {
                    System.out.print(allPeople.get(Integer.parseInt(args[i+1])).getName() + " ");
                    if (allPeople.get(Integer.parseInt(args[i+1])).getSex().equals(Sex.MALE))
                        System.out.print("m " + dateout.format(allPeople.get(Integer.parseInt(args[i+1])).getBirthDate()));
                    else
                        System.out.print("f " + dateout.format(allPeople.get(Integer.parseInt(args[i+1])).getBirthDate()));
                    System.out.println();
                }
                break;

                default:

                System.out.println("Error");
                break;
        }

    }
    }
}
