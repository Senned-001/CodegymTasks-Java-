package com.codegym.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Password generator

*/
public class Solution {
    public static void main(String[] args) throws Exception{
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword()throws Exception {
        byte[]result=new byte[8];
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(8);
        for(int i=0;i<8;i++) {
            int rand=0;
            /*int numbCounter=0;                            //adding at the end needs symbols if it needs - not valided but worked
            int downLetCount=0;
            int upLetCount=0;
            if((i>=6)&&(numbCounter==0||downLetCount==0||upLetCount==0)){
                if(numbCounter==0)rand=0;
                else if(downLetCount==0) rand=1;
                else if(upLetCount==0) rand=2;
            }else {
                rand = (int) (Math.random() * 3);
            }*/
            if(i==0)rand=0;
            else if(i==1)rand=1;
            else if(i==2)rand=2;
            else rand = (int) (Math.random() * 3);                  //random for 0,1,2

            switch (rand) {

                    case 0: {
                        //System.out.println("0");                  //0123...
                        Random random = new Random();
                        result[i] = (byte) (random.nextInt(9) + 48);
                        //numbCounter++;
                        break;
                    }
                    case 1: {
                        //System.out.println("1");                  //abcd....
                        Random random = new Random();
                        result[i] = (byte) (random.nextInt(25) + 65);
                        //downLetCount++;
                        break;
                    }
                    case 2: {
                        //System.out.println("2");                  //ABCD...
                        Random random = new Random();
                        result[i] = (byte) (random.nextInt(25) + 97);
                        //upLetCount++;
                        break;
                    }
            }
        }
        byteArrayOutputStream.write(result);
        return byteArrayOutputStream;
    }
}