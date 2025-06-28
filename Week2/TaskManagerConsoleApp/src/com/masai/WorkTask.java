package com.masai;

import java.time.LocalDate;

public class WorkTask extends Task{
    public WorkTask() {
    }

    public WorkTask(Integer id, String title, String description, Status status, LocalDate dueDate) {
        super(id, title, description, status, dueDate);
    }


    @Override
    public void displayTask() {
        System.out.println("Work Task{" +
                "id=" + super.getId() +
                ", title='" + super.getTitle() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", status='" + super.getStatus() + '\'' +
                ", dueDate=" + super.getDueDate() +
                '}');
    }



}
