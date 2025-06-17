package com.masai;

public class Student {
    private String name;
    private int rollNumber;
    private String course;
    private int marks;

    public Student(String name, int rollNumber, String course, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void displayDetails() {
        final String RESET = "\u001B[0m";
        final String CYAN = "\u001B[36m";
        final String YELLOW = "\u001B[33m";
        final String GREEN = "\u001B[32m";
        final String BLUE = "\u001B[34m";
        final String PURPLE = "\u001B[35m";
        final String RED = "\u001B[31m";

        System.out.println(PURPLE + "Student Details:" + RESET);
        System.out.println(CYAN + "=============================================" + RESET);
        System.out.println(YELLOW + "Name     : " + GREEN + this.getName());
        System.out.println(YELLOW + "Roll No. : " + BLUE + this.getRollNumber());
        System.out.println(YELLOW + "Course   : " + RED + this.getCourse());
        System.out.println(YELLOW + "Marks    : " + GREEN + this.getMarks());
        System.out.println(CYAN + "=============================================" + RESET);
    }


    public void updateMarks(int newMarks) {
        this.setMarks(newMarks);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", course='" + course + '\'' +
                ", marks=" + marks +
                '}';
    }
}
