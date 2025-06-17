package com.masai;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StudentManager {

    private List<Student> studentList = new ArrayList<>();

    public void addStudent(Scanner sc) {
        String name, course;
        int roll, marks;
        System.out.println("Enter details: ");
        System.out.println("=============================================");
        System.out.print("Student's name: ");
        name = sc.nextLine();
        System.out.print("Student's roll number: ");
        roll = Integer.parseInt(sc.nextLine());
        System.out.print("Student's course: ");
        course = sc.nextLine();
        System.out.print("Student's marks: ");
        marks = Integer.parseInt(sc.nextLine());
        System.out.println("=============================================");
        studentList.add( new Student(name, roll, course, marks));
        System.out.println("✅ Student added successfully.");
    }

    public Optional<Student> searchStudentByRollNo(int roll) {
        for (Student s : studentList) {
            if (s.getRollNumber() == roll) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty!");
            return;
        }

        for (Student s : studentList) {
            s.displayDetails();
        }
    }

}
