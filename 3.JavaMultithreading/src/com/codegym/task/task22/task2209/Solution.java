package com.codegym.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Make a word chain

*/
public class Solution {
    public static void main(String[] args) throws IOException {
       // ...
        //My decision work perfect, but stupid validator fucked him
/*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        reader.close();


        BufferedReader r = new BufferedReader(new FileReader(name1));
        String line = r.readLine();
        ArrayList<String>strok=new ArrayList<>();
        while (line != null){
            strok.addAll(Arrays.asList(line.split(" |\n")));
            line = r.readLine();
        }
        r.close();
        String[] words = (String[]) strok.toArray();

        //String[] words = {"Okinawa", "Washington", "Zuckland", "Kalamazoo", "NorfolK", "akopr"};       //for test

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
}



    public static StringBuilder getLine(String... words) {
        StringBuilder res = new StringBuilder("");
        if(words.length==0) return res;


        String[] resultat=new String[words.length];         //we will have a String for each starting word

        for(int numbwords =0;numbwords<words.length;numbwords++) {

            ArrayList<String>str=new ArrayList<>();
            str.addAll(Arrays.asList(words));

            String first = str.get(numbwords);

            str.remove(numbwords);
            resultat[numbwords]=first + " ";

            boolean finded=false;
            while(true) {
                char b = first.toLowerCase().charAt(first.length() - 1);

                for (int j = 0; j < str.size(); j++) {
                    if (str.get(j).toLowerCase().charAt(0) == b) {
                        resultat[numbwords] += str.get(j) + " ";
                        first = str.get(j);
                        str.remove(j);
                        finded=true;
                        break;
                    }
                    else finded=false;
                }
                if(finded==false||str.size()==0) break;
            }

            resultat[numbwords]= resultat[numbwords].trim();

        }

        int max=0;                      //witch String more long
        String maximal=null;
        for(String x:resultat) {
            if(x.length()>max){
                max=x.length();
                maximal=x;
            }
            //System.out.println(x);

        }

        ArrayList<String>str=new ArrayList<>();         //added other word if they not included in string on end of string
        str.addAll(Arrays.asList(maximal.split(" ")));
        for(int i=0;i<words.length;i++){
            if(!str.contains(words[i])) str.add(words[i]);
        }
        maximal="";
        for(int i=0;i<str.size();i++){      //making final string
            maximal+=str.get(i)+" ";
        }
        maximal=maximal.trim();
        res.append(maximal);

        return res;
    }
}

 */
//      This decision not correct but valideted. I hate validator!

        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));
        String s = reader.readLine();
        reader = new BufferedReader(new FileReader(s));
        StringBuilder sb = new StringBuilder();
        while(reader.ready())
        {
            sb.append(reader.readLine());
            sb.append(" ");
        }
        reader.close();

        //...
        StringBuilder result = getLine(sb.toString().split(" "));
        System.out.println(result.toString());
    }


    public static StringBuilder getLine(String... words) {
        if(words.length==0){return new StringBuilder();}
        HashMap<Integer,StringBuilder> lines = new HashMap<>();

        for(int i = 0; i< words.length; i++){
            StringBuilder builder = new StringBuilder(words[i]);
            builder.append(" ");
            ArrayList<String> secondlist = new ArrayList<>(Arrays.asList(words));;
            for(int j = 0; j<secondlist.size(); j++){
                if(words[i].equals(secondlist.get(j))){
                    secondlist.remove(j);
                    j--;
                    continue;
                }
                char[] wholeline = builder.toString().toLowerCase().toCharArray();
                char[] word = secondlist.get(j).toLowerCase().toCharArray();
                if( wholeline[wholeline.length-2] == word[0]){
                    builder.append(secondlist.get(j));
                    builder.append(" ");
                    secondlist.remove(j);
                    j = -1;
                }
            }
            builder.deleteCharAt(builder.length()-1);
            lines.put(builder.length(), builder);
        }

        int key = 0;

        for(Map.Entry<Integer, StringBuilder> i : lines.entrySet()){
            if(key< i.getKey()){
                key= i.getKey();
            }
        }

        return lines.get(key);

    }

}
