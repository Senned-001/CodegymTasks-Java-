package com.codegym.task.task39.task3913.query;

import java.util.Date;
import java.util.Set;

public interface UserQuery {
    Set<String> getAllUsers();

    int getNumberOfUsers(Date after, Date before);

    int getNumberOfUserEvents(String user, Date after, Date before);

    Set<String> getUsersForIP(String ip, Date after, Date before);

    Set<String> getUsersWhoHaveLoggedIn(Date after, Date before);

    Set<String> getUsersWhoHaveDownloadedPlugin(Date after, Date before);

    Set<String> getUsersWhoHaveSentMessages(Date after, Date before);

    Set<String> getUsersWhoHaveAttemptedTasks(Date after, Date before);

    Set<String> getUsersWhoHaveAttemptedTasks(Date after, Date before, int task);

    Set<String> getUsersWhoHaveCompletedTasks(Date after, Date before);

    Set<String> getUsersWhoHaveCompletedTasks(Date after, Date before, int task);
}