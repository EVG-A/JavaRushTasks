package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University{
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;
    public University(String name, int age) {

    }

    public Student getStudentWithAverageGrade(double grade) {
        //TODO:
        for (Student student: students){
            if (student.getAverageGrade() == grade) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double maxBal = students.get(0).getAverageGrade();
        Student s = students.get(0);
        for (Student student: students){
            double currentBal = student.getAverageGrade();
            if ( currentBal > maxBal) {
                maxBal = currentBal;
                s = student;
            }
        }
        return s;
    }
    public Student getStudentWithMinAverageGrade(){
        double maxBal = students.get(0).getAverageGrade();
        Student s = students.get(0);
        for (Student student: students){
            double currentBal = student.getAverageGrade();
            if ( currentBal <= maxBal) {
                maxBal = currentBal;
                s = student;
            }
        }
        return s;
    }

    public void expel(Student student){
        students.remove(student);
    }
    
}