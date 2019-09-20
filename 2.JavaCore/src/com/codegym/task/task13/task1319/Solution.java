package com.codegym.task.task13.task1319;

import java.io.*;

/* 
Writing to a file from the console

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fname));

        while (true){

            String lin = reader.readLine();

            if(lin.equals("exit")) {bw.write(lin); bw.flush();break;}

            bw.write(lin);  //schitivanie stroki v buffer + \n

            bw.flush();                 //zapis iz buffera v file
            bw.newLine();
        }
        reader.close();
        bw.close();
    }
}
