package com.javarush.task.task29.task2909.human;

public class Teacher extends UniversityPerson {

    protected boolean isSoldier;
    protected int course;
    private int numberOfStudents;

    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);

        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public String getPosition() {
        return "Преподаватель";
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

    public void fight() {
    }

    public int getCourse() {
        return course;
    }
}