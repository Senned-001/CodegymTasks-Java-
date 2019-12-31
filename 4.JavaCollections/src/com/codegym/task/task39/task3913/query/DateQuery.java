package com.codegym.task.task39.task3913.query;

import com.codegym.task.task39.task3913.Event;

import java.util.Date;
import java.util.Set;

public interface DateQuery {
    Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before);

    Set<Date> getDatesWhenSomethingFailed(Date after, Date before);

    Set<Date> getDatesWhenErrorOccurred(Date after, Date before);

    Date getDateWhenUserLoggedInFirstTime(String user, Date after, Date before);

    Date getDateWhenUserAttemptedTask(String user, int task, Date after, Date before);

    Date getDateWhenUserCompletedTask(String user, int task, Date after, Date before);

    Set<Date> getDatesWhenUserSentMessages(String user, Date after, Date before);

    Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before);
}