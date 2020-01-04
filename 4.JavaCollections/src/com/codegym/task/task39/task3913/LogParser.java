package com.codegym.task.task39.task3913;



import com.codegym.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
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
        } else if (after == null && before != null&&date.getTime() < before.getTime()) {
            dateGets=true;
        } else if (before == null && after != null&&date.getTime() > after.getTime()) {
            dateGets=true;
        } else if (before != null && after != null && date.getTime() > after.getTime() && date.getTime() < before.getTime()) {
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
            if(compareDates(strFromLog[2],after,before)) {
                result.add(strFromLog[0]);
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

            if(compareDates(strFromLog[2],after,before)&&user.equals(strFromLog[1])) {
                result.add(strFromLog[0]);
            }
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
            if(compareDates(strFromLog[2],after,before)&&event.equals(Event.valueOf(strFromLog[3].split(" ")[0]))) {
                result.add(strFromLog[0]);
            }
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
            if(compareDates(strFromLog[2],after,before)&&status.equals(Status.valueOf(strFromLog[4]))) {
                result.add(strFromLog[0]);
            }
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
               if(compareDates(strFromLog[2],after,before)) {
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
                if (compareDates(strFromLog[2],after,before)) {
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
                if (compareDates(strFromLog[2],after,before)) {
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
                if (compareDates(strFromLog[2],after,before)) {
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
                if (compareDates(strFromLog[2],after,before)) {
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
                if (compareDates(strFromLog[2],after,before)) {
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
                if (compareDates(strFromLog[2],after,before)) {
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
                if (compareDates(strFromLog[2],after,before)) {
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
                if (compareDates(strFromLog[2],after,before)) {
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

    @Override
    public int getNumberOfEvents(Date after, Date before) {
        return getAllEvents(after,before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event>allEvents=new HashSet<>();
        for(String[] strFromLog : logData) {
            if(compareDates(strFromLog[2],after,before)) {
                allEvents.add(Event.valueOf(strFromLog[3].split(" ")[0]));
            }
        }
        return allEvents;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event>allEvents=new HashSet<>();
        for(String[] strFromLog : logData) {
            if(compareDates(strFromLog[2],after,before)&&ip.equals(strFromLog[0])) {
                allEvents.add(Event.valueOf(strFromLog[3].split(" ")[0]));
            }
        }
        return allEvents;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event>allEvents=new HashSet<>();
        for(String[] strFromLog : logData) {
            if(compareDates(strFromLog[2],after,before)&&user.equals(strFromLog[1])) {
                allEvents.add(Event.valueOf(strFromLog[3].split(" ")[0]));
            }
        }
        return allEvents;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event>allEvents=new HashSet<>();
        for(String[] strFromLog : logData) {
            if(compareDates(strFromLog[2],after,before)&&Status.valueOf(strFromLog[4]).equals(Status.FAILED)) {
                allEvents.add(Event.valueOf(strFromLog[3].split(" ")[0]));
            }
        }
        return allEvents;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event>allEvents=new HashSet<>();
        for(String[] strFromLog : logData) {
            if(compareDates(strFromLog[2],after,before)&&Status.valueOf(strFromLog[4]).equals(Status.ERROR)) {
                allEvents.add(Event.valueOf(strFromLog[3].split(" ")[0]));
            }
        }
        return allEvents;
    }

    @Override
    public int getNumberOfAttemptsToCompleteTask(int task, Date after, Date before) {
        int count=0;
        String t=task+"";
        for(String[] strFromLog : logData) {
            if(compareDates(strFromLog[2],after,before)
                    &&Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.ATTEMPT_TASK)
                    &&t.equals(strFromLog[3].split(" ")[1])){
                count++;
            }
        }
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptsToCompleteTask(int task, Date after, Date before) {
        int count=0;
        String t=task+"";
        for(String[] strFromLog : logData) {
            if(compareDates(strFromLog[2],after,before)
                    &&Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.COMPLETE_TASK)
                    &&t.equals(strFromLog[3].split(" ")[1])){
                count++;
            }
        }
        return count;
    }

    @Override
    public Map<Integer, Integer> getAllAttemptedTasksAndNumberOfAttempts(Date after, Date before) {
        Map<Integer, Integer>AllAttemptedTasksAndNumberOfAttempts=new HashMap<>();
        for(String[] strFromLog : logData) {
            if(compareDates(strFromLog[2],after,before)&&Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.ATTEMPT_TASK)){
                int task=Integer.parseInt(strFromLog[3].split(" ")[1]);
                if(AllAttemptedTasksAndNumberOfAttempts.containsKey(task)){
                    AllAttemptedTasksAndNumberOfAttempts.put(task,AllAttemptedTasksAndNumberOfAttempts.get(task)+1);
                }else AllAttemptedTasksAndNumberOfAttempts.put(task,1);
            }
        }
        return AllAttemptedTasksAndNumberOfAttempts;
    }

    @Override
    public Map<Integer, Integer> getAllCompletedTasksAndNumberOfCompletions(Date after, Date before) {
        Map<Integer, Integer>AllCompletedTasksAndNumberOfCompletions=new HashMap<>();
        for(String[] strFromLog : logData) {
            if(compareDates(strFromLog[2],after,before)&&Event.valueOf(strFromLog[3].split(" ")[0]).equals(Event.COMPLETE_TASK)){
                int task=Integer.parseInt(strFromLog[3].split(" ")[1]);
                if(AllCompletedTasksAndNumberOfCompletions.containsKey(task)){
                    AllCompletedTasksAndNumberOfCompletions.put(task,AllCompletedTasksAndNumberOfCompletions.get(task)+1);
                }else AllCompletedTasksAndNumberOfCompletions.put(task,1);
            }
        }
        return AllCompletedTasksAndNumberOfCompletions;
    }

    public Set<Date>getAllDates(){
        Set<Date>AllDates=new HashSet<>();
        for(String[] strFromLog : logData) {
            Date date = null;
            try {
                date = df.parse(strFromLog[2]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            AllDates.add(date);
        }
        return AllDates;
    }

    public Set<Status>getAllStatus(){
        Set<Status>AllStatus=new HashSet<>();
        for(String[] strFromLog : logData) {
            AllStatus.add(Status.valueOf(strFromLog[4]));
            if(AllStatus.size()==3) break;
        }
        return AllStatus;
    }

    @Override
    public Set<Object> execute(String query) {
        switch (query){
            case "get ip" : return new HashSet<>(getUniqueIPs(null,null));
            case "get user" : return new HashSet<>(getAllUsers());
            case "get date" : return new HashSet<>(getAllDates());
            case "get event" : return new HashSet<>(getAllEvents(null,null));
            case "get status" : return new HashSet<>(getAllStatus());
        }
        //if query have format: get field1 for field2 = "value1" then:
        String field1 = query.split(" ")[1];
        String field2 = query.split(" ")[3];
        String value1 = query.split("=")[1].trim();
        value1 = value1.substring(1, value1.length() - 1);
        Date dateAfter = null;
        Date dateBefore = null;

        //if query have format: get field1 for field2 = "value1" and date between "after" and "before"
        if(query.contains("and date between")){
            value1=value1.split(" and date between")[0];
            value1= value1.substring(0, value1.length() - 1);
            String after=query.split("and date between ")[1];
            after=after.split(" and")[0];
            after=after.substring(1, after.length() - 1);
            String before=query.split("and date between ")[1];
            before=before.split("and ")[1];
            before=before.substring(1, before.length() - 1);

            try {
                dateAfter = df.parse(after);
                dateBefore = df.parse(before);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        int indexForField1=0;               //index of element in logdata for result
        int indexForField2=0;               //index of element in logdata for filter with value
        switch (field1){
            case "ip" : {indexForField1=0;break;}
            case "user" : {indexForField1=1;break;}
            case "date" : {indexForField1=2;break;}
            case "event" : {indexForField1=3;break;}
            case "status" : {indexForField1=4;break;}
        }
        switch (field2){
            case "ip" : {indexForField2=0;break;}
            case "user" : {indexForField2=1;break;}
            case "date" : {indexForField2=2;break;}
            case "event" : {indexForField2=3;break;}
            case "status" : {indexForField2=4;break;}
        }

        Set<Object> result=new HashSet<>();
        for(String[] strFromLog : logData) {
            if(field1.equals("date")){
                if(field2.equals("event")){                         //if filter on event element it needs only name without number of task
                    if(compareDates(strFromLog[2],dateAfter,dateBefore)&&strFromLog[indexForField2].split(" ")[0].equals(value1)){
                        Date date = null;
                        try {
                            date = df.parse(strFromLog[indexForField1]);
                        } catch (ParseException e) {
                            continue;
                        }
                        result.add(date);
                    }
                }
                else{
                    if(compareDates(strFromLog[2],dateAfter,dateBefore)&&strFromLog[indexForField2].equals(value1)){
                        Date date = null;
                        try {
                            date = df.parse(strFromLog[indexForField1]);
                        } catch (ParseException e) {
                            continue;
                        }
                        result.add(date);
                    }
                }
            }
            else if(field1.equals("event")){
                if(compareDates(strFromLog[2],dateAfter,dateBefore)&&strFromLog[indexForField2].equals(value1)){
                    result.add(Event.valueOf(strFromLog[indexForField1].split(" ")[0]));
                }
            }
            else if(field1.equals("status")){
                if(field2.equals("event")) {
                    if (compareDates(strFromLog[2],dateAfter,dateBefore)&&strFromLog[indexForField2].split(" ")[0].equals(value1)) {
                        result.add(Status.valueOf(strFromLog[indexForField1]));
                    }
                }
                else{
                    if(compareDates(strFromLog[2],dateAfter,dateBefore)&&strFromLog[indexForField2].equals(value1)){
                        result.add(Status.valueOf(strFromLog[indexForField1]));
                    }
                }
            }
            else{
                if(field2.equals("event")) {
                    if (compareDates(strFromLog[2],dateAfter,dateBefore)&&strFromLog[indexForField2].split(" ")[0].equals(value1)) {
                        result.add(strFromLog[indexForField1]);
                    }
                }
                else{
                    if(compareDates(strFromLog[2],dateAfter,dateBefore)&&strFromLog[indexForField2].equals(value1)) {
                        result.add(strFromLog[indexForField1]);
                    }
                }
            }
        }
        return result;
    }
}