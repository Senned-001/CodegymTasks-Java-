package com.codegym.task.task29.task2909.user;

public class User {
    private String firstName;
    private String lastName;
    private int age;

    private Job job;
    private Address address;
    private boolean male;

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }
    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void printInfo(){
        System.out.println("First name: "+this.firstName);
        System.out.println("Last name: "+this.lastName);
    }

    public void printAdditionalInfo() {
        if (this.age<16)
            System.out.println("User is younger than 16");
        else
            System.out.println("User is at least 16");
    }

    public String getAddress() {
        return address.getCountry() + " " + address.getCity() + " " + address.getHouse();
    }

    public String getCountry(){
       return address.getCountry();
    }

    public void setCountry(String country){
        address.setCountry(country);
    }

    public String getCity(){
       return address.getCity();
    }

    public void setCity(String city){
        address.setCity(city);
    }


    public String getBoss(){
        return this.job.getBoss();
    }
}