package com.codegym.task.task22.task2207;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* 
Inverted words

*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        reader.close();

        BufferedReader r = new BufferedReader(new FileReader(name1));
        String line = r.readLine();
        //String line = "rat tar tart a\n" +        //for checking
               // "a tot tot tot";
        //decision 1 - it works but validator is a bitch
 /*          ArrayList<String>str=new ArrayList<>();
             while (line != null){
            String[]s=line.split(" |\\n");
            for(int i =0;i<s.length;i++){       //str.addAll(Arrays.asList(s);
                str.add(s[i]);
            }
            line = r.readLine();
        }*/
        HashSet<String> values = new HashSet<>();
        while (line != null){
            for(String x: line.split(" "))
            {
                StringBuilder rev=new StringBuilder(x);
                String x2=rev.reverse().toString();
                if(values.contains(x2)){
                    values.remove(x2);
                    result.add(new Pair(x,x2));
                }else
                    values.add(x);
            }
            line = r.readLine();
        }
        r.close();
/*      //decision 1 - it works but validator is a bitch
        for(String x:str){
            StringBuilder sn = new StringBuilder(x);
            String x2=sn.reverse().toString();
            //System.out.println(x+" "+x2);
            if(str.contains(x2)) {
                //System.out.println("YES");
                Pair newpair =new Pair(x,x2);
                Pair newpairreverse=new Pair(x2,x);
                if(!result.contains(newpair)&&!result.contains(newpairreverse)) {
                    result.add(newpair);
                    //System.out.println("ADDED");
                }
            }
        }
*/
        for(Pair x:result){
            System.out.println(x);
        }
    }

    public static class Pair {
        String first;
        String second;

    public Pair (){

    }
    public Pair (String first, String second){
        this.first=first;
        this.second=second;
    }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Pair pair = (Pair) o;
            if (first != null ? !first.equals(pair.first) : pair.first != null)
                return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }

}