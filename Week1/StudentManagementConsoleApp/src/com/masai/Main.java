package com.masai;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        System.out.println("Application started...");
        Scanner sc = new Scanner(System.in);
        int selected;

        do {
            System.out.println("\n===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by roll number");
            System.out.println("3. Update student marks");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            try {
                selected = Integer.parseInt(sc.nextLine());

                switch (selected) {
                    case 1:
                        sm.addStudent(sc);
                        break;

                    case 2:
                        while (true) {
                            System.out.println("Enter roll no. to search (or type 'M' for main menu): ");
                            String text = sc.nextLine();
                            if (text.equals("M")) break;

                            try {
                                int roll = Integer.parseInt(text);
                                Optional<Student> optional = sm.searchStudentByRollNo(roll);
                                if (optional.isPresent()) {
                                    optional.get().displayDetails();
                                    break;
                                } else {
                                    System.out.println("No student found with roll number " + roll + ". Try again.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a number or 'M'.");
                            }
                        }
                        break;

                    case 3:
                        while (true) {
                            System.out.println("Enter roll no. to update marks (or type 'M' for main menu): ");
                            String text = sc.nextLine();
                            if (text.equals("M")) break;

                            try {
                                int roll = Integer.parseInt(text);
                                Optional<Student> opt = sm.searchStudentByRollNo(roll);
                                if (opt.isPresent()) {
                                    Student s = opt.get();
                                    System.out.print("Enter new marks: ");
                                    int marks = Integer.parseInt(sc.nextLine());
                                    s.updateMarks(marks);
                                    System.out.println("Marks updated. Updated details:");
                                    s.displayDetails();
                                    break;
                                } else {
                                    System.out.println("No student found with roll number " + roll + ". Try again.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid number or 'M'.");
                            }
                        }
                        break;

                    case 4:
                        sm.displayAllStudents();
                        break;

                    case 5:
                        break;

                    default:
                        System.out.println("Invalid selection, try again!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please enter a number between 1 and 5.");
                selected = 0;
            }

        } while (selected != 5);

        System.out.println("Application closed.");
    }
}
