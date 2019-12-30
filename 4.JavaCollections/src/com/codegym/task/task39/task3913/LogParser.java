package com.codegym.task.task39.task3913;



import com.codegym.task.task39.task3913.query.IPQuery;

import java.io.*;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery {
    private Path logDir;
    private List<String[]> logData;
    private DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);


    public LogParser(Path logDir) {
        this.logDir = logDir;
        this.logData = new ArrayList<>();
        readLogs(logDir);
    }

    private void readLogs(Path path) {
        File files = path.toFile();
        File[] logsFiles = files.listFiles();
        List<File>logsFilesCorrect=new ArrayList<>();
        for (File f : logsFiles) {
            if (f.getName().toLowerCase().endsWith(".log")) ;
            logsFilesCorrect.add(f);
        }

        for (File f : logsFiles) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                String s;
                while ((s = reader.readLine()) != null) {
                    String[] tempData = s.split(" |\t");
                    String[] tempCorrectData = new String[5];

                    tempCorrectData[0] = (tempData[0]);                                     //insert ip

                    String spl = null;
                    int index = 1;
                    for (int i = index; i < tempData.length; i++) {                        //insert name as one string
                        if (tempData[i].toLowerCase().matches("[a-z]"))
                            spl = spl + tempData[i] + " ";
                        else {
                            tempCorrectData[1] = spl.trim();
                            index = i;                                                      //save index for time
                        }
                    }

                    tempCorrectData[2] = tempData[index] + " " + tempData[++index];         //save time as one string

                    if (tempData[tempData.length - 2].matches("\\d"))
                        tempCorrectData[3] = tempData[++index] + " " + tempData[++index];   //save event as one string
                    else tempCorrectData[3] = tempData[++index];

                    tempCorrectData[4] = tempData[tempData.length - 1];                     //save state

                    logData.add(tempCorrectData);                                               //adding data in correct format
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after,before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String>result=new HashSet<>();
        for(String[] strFromLog : logData){
            Date date = null;
            try {
                date = df.parse(strFromLog[2]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if(after==null&&before==null) {
                result.add(strFromLog[0]);
            }
            else if(after==null&&date.getTime()<=before.getTime()){
                result.add(strFromLog[0]);
            }
            else if(before==null&&date.getTime()>=after.getTime()){
                result.add(strFromLog[0]);
            }
            else if(date.getTime()>=after.getTime()&&date.getTime()<=before.getTime())
                result.add(strFromLog[0]);
        }
        return result;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String>result=new HashSet<>();
        for(String[] strFromLog : logData){
            Date date = null;
            try {
                date = df.parse(strFromLog[2]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if(after==null&&before==null&&user.equals(strFromLog[1])) {
                result.add(strFromLog[0]);
            }
            else if(after==null&&date.getTime()<=before.getTime()&&user.equals(strFromLog[1])){
                result.add(strFromLog[0]);
            }
            else if(before==null&&date.getTime()>=after.getTime()&&user.equals(strFromLog[1])){
                result.add(strFromLog[0]);
            }
            else if(date.getTime()>=after.getTime()&&date.getTime()<=before.getTime()&&user.equals(strFromLog[1]))
                result.add(strFromLog[0]);
        }
        return result;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String>result=new HashSet<>();
        for(String[] strFromLog : logData){
            Date date = null;
            try {
                date = df.parse(strFromLog[2]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if(after==null&&before==null&&event.equals(strFromLog[3])) {
                result.add(strFromLog[0]);
            }
            else if(after==null&&date.getTime()<=before.getTime()&&event.equals(strFromLog[3])){
                result.add(strFromLog[0]);
            }
            else if(before==null&&date.getTime()>=after.getTime()&&event.equals(strFromLog[3])){
                result.add(strFromLog[0]);
            }
            else if(date.getTime()>=after.getTime()&&date.getTime()<=before.getTime()&&event.equals(strFromLog[3]))
                result.add(strFromLog[0]);
        }
        return result;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String>result=new HashSet<>();
        for(String[] strFromLog : logData){
            Date date = null;
            try {
                date = df.parse(strFromLog[2]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if(after==null&&before==null&&status.equals(strFromLog[4])) {
                result.add(strFromLog[0]);
            }
            else if(after==null&&date.getTime()<=before.getTime()&&status.equals(strFromLog[4])){
                result.add(strFromLog[0]);
            }
            else if(before==null&&date.getTime()>=after.getTime()&&status.equals(strFromLog[4])){
                result.add(strFromLog[0]);
            }
            else if(date.getTime()>=after.getTime()&&date.getTime()<=before.getTime()&&status.equals(strFromLog[4]))
                result.add(strFromLog[0]);
        }
        return result;
    }
}