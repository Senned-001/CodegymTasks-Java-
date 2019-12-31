package com.codegym.task.task39.task3913;



import com.codegym.task.task39.task3913.query.DateQuery;
import com.codegym.task.task39.task3913.query.IPQuery;
import com.codegym.task.task39.task3913.query.UserQuery;

import java.io.*;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery {
    private Path logDir;
    private List<String[]> logData;
    private DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");


    public LogParser(Path logDir) {
        this.logDir = logDir;
        this.logData = new ArrayList<>();
        readLogs(logDir);
    }

    private void readLogs(Path path) {
        File files = path.toFile();
        File[] logsFiles = files.listFiles();

        for (File f : logsFiles) {
            if(f.getName().toLowerCase().endsWith(".log")) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(f));
                    String s;
                    while ((s = reader.readLine()) != null) {
                        String[] tempData = s.split("\t");
                        logData.add(tempData);                                               //adding data in correct format
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public boolean compareDates(String dateToCompare, Date after, Date before){
        boolean dateGets =false;
        Date date = null;
        try {
            date = df.parse(dateToCompare);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (after == null && before == null) {
            dateGets=true;
        } else if (after == null && before != null&&date.getTime() <= before.getTime()) {
            dateGets=true;
        } else if (before == null && after != null&&date.getTime() >= after.getTime()) {
            dateGets=true;
        } else if (before != null && after != null && date.getTime() >= after.getTime() && date.getTime() <= before.getTime()) {
            dateGets=true;
        }
        return dateGets;
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
                //System.out.println(date);
            } catch (ParseException e) {
                System.out.println("Incorrect date format");
                continue;
            }

            if(after==null&&before==null) {
                result.add(strFromLog[0]);
                //System.out.println("Adding");
            }
            else if(after==null&&date.getTime()<=before.getTime()){
                result.add(strFromLog[0]);
                //System.out.println("Adding");

            }
            else if(before==null&&date.getTime()>=after.getTime()){
                result.add(strFromLog[0]);
                //System.out.println("Adding");
            }
            else if(before!=null&&after!=null&&date.getTime()>=after.getTime()&&date.getTime()<=before.getTime()){
                result.add(strFromLog[0]);
                //System.out.println("Adding");
            }
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
            else if(after==null&&before!=null&&date.getTime()<=before.getTime()&&user.equals(strFromLog[1])){
                result.add(strFromLog[0]);
            }
            else if(before==null&&after!=null&&date.getTime()>=after.getTime()&&user.equals(strFromLog[1])){
                result.add(strFromLog[0]);
            }
            else if(before!=null&&after!=null&&date.getTime()>=after.getTime()&&date.getTime()<=before.getTime()&&user.equals(strFromLog[1]))
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

            if(after==null&&before==null&&event.equals(Event.valueOf(strFromLog[3].split(" ")[0]))) {
                result.add(strFromLog[0]);
            }
            else if(after==null&&before!=null&&date.getTime()<=before.getTime()&&event.equals(Event.valueOf(strFromLog[3].split(" ")[0]))){
                result.add(strFromLog[0]);
            }
            else if(before==null&&after!=null&&date.getTime()>=after.getTime()&&event.equals(Event.valueOf(strFromLog[3].split(" ")[0]))){
                result.add(strFromLog[0]);
            }
            else if(before!=null&&after!=null&&date.getTime()>=after.getTime()&&date.getTime()<=before.getTime()&&event.equals(Event.valueOf(strFromLog[3].split(" ")[0])))
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

            if(after==null&&before==null&&status.equals(Status.valueOf(strFromLog[4]))) {
                result.add(strFromLog[0]);
            }
            else if(after==null&&before!=null&&date.getTime()<=before.getTime()&&status.equals(Status.valueOf(strFromLog[4]))){
                result.add(strFromLog[0]);
            }
            else if(before==null&&after!=null&&date.getTime()>=after.getTime()&&status.equals(Status.valueOf(strFromLog[4]))){
                result.add(strFromLog[0]);
            }
            else if(before!=null&&after!=null&&date.getTime()>=after.getTime()&&date.getTime()<=before.getTime()&&status.equals(Status.valueOf(strFromLog[4])))
                result.add(strFromLog[0]);
        }
        return result;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> allUsers=new HashSet<>();
        for(String[] strFromLog : logData){
            allUsers.add(strFromLog[1]);
        }
        return allUsers;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        int count=0;
        for(String user : getAllUsers()){
            Set<String> result=getIPsForUser(user,after,before);
            if(!result.isEmpty()) count++;
        }
        return count;
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<String> uniqueEvents=new HashSet<>();
        for(String[] strFromLog : logData){
           if(strFromLog[1].equals(user)) {
               Date date = null;
               try {
                   date = df.parse(strFromLog[2]);
               } catch (ParseException e) {
                   e.printStackTrace();
               }

               if(after==null&&before==null) {
                   uniqueEvents.add(strFromLog[3]);
               }
               else if(after==null&&before!=null&&date.getTime()<=before.getTime()){
                   uniqueEvents.add(strFromLog[3]);

               }
               else if(before==null&&after!=null&&date.getTime()>=after.getTime()){
                   uniqueEvents.add(strFromLog[3]);
               }
               else if(before!=null&&after!=null&&date.getTime()>=after.getTime()&&date.getTime()<=before.getTime()){
                   uniqueEvents.add(strFromLog[3]);
               }
           }
        }
        return uniqueEvents.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> users=new HashSet<>();
        for(String[] strFromLog : logData){
            if(strFromLog[0].equals(ip)) {
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (after == null && before == null) {
                    users.add(strFromLog[1]);
                } else if (after == null && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);

                } else if (before == null && date.getTime() >= after.getTime()) {
                    users.add(strFromLog[1]);
                } else if (before != null && after != null && date.getTime() >= after.getTime() && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getUsersWhoHaveLoggedIn(Date after, Date before) {
        Set<String> users=new HashSet<>();
        for(String[] strFromLog : logData){
            if(Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.LOGIN)) {
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (after == null && before == null) {
                    users.add(strFromLog[1]);
                } else if (after == null && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);
                } else if (before == null && date.getTime() >= after.getTime()) {
                    users.add(strFromLog[1]);
                } else if (before != null && after != null && date.getTime() >= after.getTime() && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getUsersWhoHaveDownloadedPlugin(Date after, Date before) {
        Set<String> users=new HashSet<>();
        for(String[] strFromLog : logData){
            if(Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.DOWNLOAD_PLUGIN)) {
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (after == null && before == null) {
                    users.add(strFromLog[1]);
                } else if (after == null && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);
                } else if (before == null && date.getTime() >= after.getTime()) {
                    users.add(strFromLog[1]);
                } else if (before != null && after != null && date.getTime() >= after.getTime() && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getUsersWhoHaveSentMessages(Date after, Date before) {
        Set<String> users=new HashSet<>();
        for(String[] strFromLog : logData){
            if(Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.SEND_MESSAGE)) {
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (after == null && before == null) {
                    users.add(strFromLog[1]);
                } else if (after == null && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);
                } else if (before == null && date.getTime() >= after.getTime()) {
                    users.add(strFromLog[1]);
                } else if (before != null && after != null && date.getTime() >= after.getTime() && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getUsersWhoHaveAttemptedTasks(Date after, Date before) {
        Set<String> users=new HashSet<>();
        for(String[] strFromLog : logData){
            if(Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.ATTEMPT_TASK)) {
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (after == null && before == null) {
                    users.add(strFromLog[1]);
                } else if (after == null && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);
                } else if (before == null && date.getTime() >= after.getTime()) {
                    users.add(strFromLog[1]);
                } else if (before != null && after != null && date.getTime() >= after.getTime() && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getUsersWhoHaveAttemptedTasks(Date after, Date before, int task) {
        Set<String> users=new HashSet<>();
        String t=task+"";
        for(String[] strFromLog : logData){
            if(Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.ATTEMPT_TASK)&&strFromLog[3].split(" ")[1].equals(t)) {
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (after == null && before == null) {
                    users.add(strFromLog[1]);
                } else if (after == null && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);
                } else if (before == null && date.getTime() >= after.getTime()) {
                    users.add(strFromLog[1]);
                } else if (before != null && after != null && date.getTime() >= after.getTime() && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getUsersWhoHaveCompletedTasks(Date after, Date before) {
        Set<String> users=new HashSet<>();
        for(String[] strFromLog : logData){
            if(Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.COMPLETE_TASK)) {
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (after == null && before == null) {
                    users.add(strFromLog[1]);
                } else if (after == null && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);

                } else if (before == null && date.getTime() >= after.getTime()) {
                    users.add(strFromLog[1]);
                } else if (before != null && after != null && date.getTime() >= after.getTime() && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getUsersWhoHaveCompletedTasks(Date after, Date before, int task) {
        Set<String> users=new HashSet<>();
        String t=task+"";
        for(String[] strFromLog : logData){
            if(Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.COMPLETE_TASK)&&strFromLog[3].split(" ")[1].equals(t)) {
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (after == null && before == null) {
                    users.add(strFromLog[1]);
                } else if (after == null && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);

                } else if (before == null && date.getTime() >= after.getTime()) {
                    users.add(strFromLog[1]);
                } else if (before != null && after != null && date.getTime() >= after.getTime() && date.getTime() <= before.getTime()) {
                    users.add(strFromLog[1]);
                }
            }
        }
        return users;
    }



    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> dates=new HashSet<>();
        for(String[] strFromLog : logData){
            if(user.equals(strFromLog[1])&&Event.valueOf(strFromLog[3].split(" ")[0]).equals(event)&&compareDates(strFromLog[2],after,before)){
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dates.add(date);
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> dates=new HashSet<>();
        for(String[] strFromLog : logData){
            if(Status.valueOf(strFromLog[4]).equals(Status.FAILED)&&compareDates(strFromLog[2],after,before)){
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dates.add(date);
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenErrorOccurred(Date after, Date before) {
        Set<Date> dates=new HashSet<>();
        for(String[] strFromLog : logData){
            if(Status.valueOf(strFromLog[4]).equals(Status.ERROR)&&compareDates(strFromLog[2],after,before)){
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dates.add(date);
            }
        }
        return dates;
    }

    @Override
    public Date getDateWhenUserLoggedInFirstTime(String user, Date after, Date before) {
        Set<Date> dates=new HashSet<>();
        for(String[] strFromLog : logData){
            if(user.equals(strFromLog[1])&&Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.LOGIN)&&compareDates(strFromLog[2],after,before)){
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dates.add(date);
            }
        }
        if(dates.isEmpty()) return null;
        return Collections.min(dates);
    }

    @Override
    public Date getDateWhenUserAttemptedTask(String user, int task, Date after, Date before) {
        String t=task+"";
        Set<Date> dates=new HashSet<>();
        for(String[] strFromLog : logData){
            if(user.equals(strFromLog[1])&&Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.ATTEMPT_TASK)&&t.equals(strFromLog[3].split(" ")[1])&&compareDates(strFromLog[2],after,before)){
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dates.add(date);
            }
        }
        if(dates.isEmpty()) return null;
        return Collections.min(dates);
    }

    @Override
    public Date getDateWhenUserCompletedTask(String user, int task, Date after, Date before) {
        String t=task+"";
        Set<Date> dates=new HashSet<>();
        for(String[] strFromLog : logData){
            if(user.equals(strFromLog[1])&&Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.COMPLETE_TASK)&&t.equals(strFromLog[3].split(" ")[1])&&compareDates(strFromLog[2],after,before)){
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dates.add(date);
            }
        }
        if(dates.isEmpty()) return null;
        return Collections.min(dates);
    }

    @Override
    public Set<Date> getDatesWhenUserSentMessages(String user, Date after, Date before) {
        Set<Date> dates=new HashSet<>();
        for(String[] strFromLog : logData){
            if(user.equals(strFromLog[1])&&Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.SEND_MESSAGE)&&compareDates(strFromLog[2],after,before)){
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dates.add(date);
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> dates=new HashSet<>();
        for(String[] strFromLog : logData){
            if(user.equals(strFromLog[1])&&Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.DOWNLOAD_PLUGIN)&&compareDates(strFromLog[2],after,before)){
                Date date = null;
                try {
                    date = df.parse(strFromLog[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dates.add(date);
            }
        }
        return dates;
    }
}