package com.codegym.task.task19.task1918;

/* 
Introducing tags

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        reader.close();

        BufferedReader read1f = new BufferedReader(new FileReader(name1));
        String data="";
        String result="";
        while ((data=read1f.readLine())!=null){
            String[] sdata=data.split("\\n|\\r");   //remove symbols \n i \r from strings and write all file in one string
            for(int i=0;i<sdata.length;i++)
                result+=sdata[i];
        }
        read1f.close();

        String otag="<"+args[0];
        String ctag="</"+args[0]+">";
       /* String result = "Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Leela Turanga\n" +
                "</span></b></span><span>Super</span><span>girl</span>";
        String otag="<span";
        String ctag="</span>";
*/
        ArrayList<String> str = new ArrayList<>();
        result=result.replaceAll(otag,"¤"); //change tegs for symbols for comfort
        result=result.replaceAll(ctag,"†");

        int kol=0;                                      //finding number of pairs of tegs
        for(int i=0;i<result.length();i++){
            if(result.charAt(i)=='¤') kol++;
        }

        for(int j=0;j<kol;j++) {
            int op = 0, cl = 0;                         //counter for tegs

            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(i) == '¤') op++;      //finding open teg
                else if (result.charAt(i) == '†') {     //finding closer teg
                    cl++;
                    if (op == cl) {                 //if numbers open=closer - position of end of teg
                        str.add(otag+result.substring(result.indexOf('¤') + 1, i)+ctag);    //add to list
                        result=result.substring(0,i)+" "+result.substring(i+1);             //delete <
                        result=result.replaceFirst("¤", " ");              //delete >
                        break;
                    }
                }
            }
        }
        for(int i=0;i<str.size();i++){
            if(str.get(i).contains("¤")||str.get(i).contains("†")){ //changing if need symbols on tegs (if we have inner tegs)
                str.set(i, str.get(i).replaceAll("¤", otag));
                str.set(i, str.get(i).replaceAll("†", ctag));
            }
        }

        for (String x: str) {
            System.out.println(x);
        }
    }
}
