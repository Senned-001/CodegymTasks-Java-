package com.codegym.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnna = new User("Anna", "Larsen", 10);
    private User userRoman = new User("Roman", "Crouch", 30);

    private boolean isAnnaMale = false;
    private boolean isRomanMale = true;

    public void printUsers() {
        System.out.println("First name: " + userAnna.getFirstName());
        System.out.println("Last name: " + userAnna.getLastName());
        printAdditionalInfo(userAnna);

        System.out.println("First name: " + userRoman.getFirstName());
        System.out.println("Last name: " + userRoman.getLastName());
        printAdditionalInfo(userRoman);
    }

    public void printAdditionalInfo(User user) {
        if (ageLessThan16(user))
            System.out.println("User is younger than 16");
        else
            System.out.println("User is at least 16");
    }

    private boolean ageLessThan16(User user) {
        if (user.getAge() < 16) {
            return true;
        }
        return false;
    }

    public int calculateAverageAge() {
        int age = 28;
        User userGeorge = new User("George", "Carp", age);

        age = (userAnna.getAge() + userRoman.getAge() + userGeorge.getAge()) / 3;

        return age;
    }

    public void calculateRate(AtomicInteger base, int age, boolean hasJob, boolean hasHouse) {
        base.set(base.get() + age / 100);
        base.set((int) (base.get() * (hasJob ? 1.1 : 0.9)));
        base.set((int) (base.get() * (hasHouse ? 1.1 : 0.9)));
    }

    public String getBossName(User user) {
        Job job = user.getJob();
        return job.getBoss();
    }
}