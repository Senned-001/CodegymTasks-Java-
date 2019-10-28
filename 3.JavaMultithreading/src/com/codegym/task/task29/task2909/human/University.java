package com.codegym.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students;

    public University(String name, int age) {
        this.name=name;
        this.age=age;
        this.students=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for(Student x:students){
            if (x.getAverageGrade()==averageGrade) return x;
        }
        return null;
    }

    public Student getStudentWithHighestAverageGrade() {
        double max=0;
        Student best=null;
        for(Student x:students){
            if(x.getAverageGrade()>max){
                max=x.getAverageGrade();
                best=x;
            }
        }
        return best;
    }

    public Student getStudentWithLowestAverageGrade() {
        double min=5;
        Student worst=null;
        for(Student x:students){
            if(x.getAverageGrade()<min){
                min=x.getAverageGrade();
                worst=x;
            }
        }
        return worst;
    }

    public void expel(Student student){
        students.remove(student);
    }
}