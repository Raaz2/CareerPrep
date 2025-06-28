package com.masai;

import java.time.LocalDate;

public class PersonalTask extends Task{

    public PersonalTask() {
    }

    public PersonalTask(Integer id, String title, String description, Status status, LocalDate dueDate) {
        super(id, title, description, status, dueDate);
    }

    @Override
    public void displayTask() {
        System.out.println("Personal Task{" +
                "id=" + super.getId() +
                ", title='" + super.getTitle() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", status='" + super.getStatus() + '\'' +
                ", dueDate=" + super.getDueDate() +
                '}');
    }

}
