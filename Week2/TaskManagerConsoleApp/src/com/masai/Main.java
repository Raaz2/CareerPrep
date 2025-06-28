package com.masai;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static int taskIdCounter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        System.out.println("📋 Task Manager Application Started");

        while (true) {
            System.out.println("\n--- 📌 Task Manager Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Search Task by ID");
            System.out.println("4. Update Task Status");
            System.out.println("5. Delete Task");
            System.out.println("6. Filter by Status");
            System.out.println("7. Sort by Due Date");
            System.out.println("0. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // flush newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Description: ");
                        String desc = sc.nextLine();
                        System.out.print("Due date (yyyy-mm-dd): ");
                        LocalDate dueDate = LocalDate.parse(sc.nextLine());
                        System.out.print("Type (1-Work, 2-Personal): ");
                        int type = sc.nextInt();
                        sc.nextLine(); // flush

                        Task task = (type == 1)
                                ? new WorkTask(taskIdCounter++, title, desc, Status.PENDING, dueDate)
                                : new PersonalTask(taskIdCounter++, title, desc, Status.PENDING, dueDate);

                        manager.addTask(task);
                        System.out.println("✅ Task added successfully.");
                        break;

                    case 2:
                        System.out.println("📋 All Tasks:");
                        manager.getAllTasks().forEach(Task::displayTask);
                        break;

                    case 3:
                        System.out.print("Enter ID to search: ");
                        int idSearch = sc.nextInt();
                        sc.nextLine();

                        manager.searchTaskById(idSearch)
                                .ifPresentOrElse(
                                        taskFound -> {
                                            System.out.println("✅ Task found:");
                                            taskFound.displayTask();
                                        },
                                        () -> System.out.println("❌ Task not found with ID: " + idSearch)
                                );
                        break;

                    case 4:
                        System.out.print("Enter ID to update status: ");
                        int idUpdate = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new status (1 = Pending, 2 = Completed): ");
                        String input = sc.nextLine();
                        Status newStatus = null;

                        if (input.equals("1")) newStatus = Status.PENDING;
                        else if (input.equals("2")) newStatus = Status.COMPLETED;
                        else {
                            System.out.println("❌ Invalid status input.");
                            break;
                        }

                        manager.updateTaskStatus(idUpdate, newStatus);
                        System.out.println("✅ Task status updated.");
                        break;

                    case 5:
                        System.out.print("Enter ID to delete: ");
                        int idDelete = sc.nextInt();
                        sc.nextLine();

                        manager.removeTask(idDelete);
                        System.out.println("🗑️ Task deleted successfully.");
                        break;

                    case 6:
                        System.out.print("Filter status - Enter (1 = Pending, 2 = Completed): ");
                        String statusInput = sc.nextLine();
                        Status filterStatus = null;

                        if (statusInput.equals("1")) filterStatus = Status.PENDING;
                        else if (statusInput.equals("2")) filterStatus = Status.COMPLETED;
                        else {
                            System.out.println("❌ Invalid status input.");
                            break;
                        }

                        System.out.println("📂 Filtered tasks by status:");
                        manager.filterByStatus(filterStatus).forEach(Task::displayTask);
                        break;

                    case 7:
                        System.out.println("📅 Tasks sorted by due date:");
                        manager.sortByDueDate().forEach(Task::displayTask);
                        break;

                    case 0:
                        System.out.println("👋 Exiting Task Manager...");
                        return;

                    default:
                        System.out.println("❌ Invalid choice. Please select a valid option.");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        }
    }
}
