package com.masai;

import java.util.List;
import java.util.Optional;

public interface TaskOperations {
    void addTask(Task task);
    void removeTask(int id);
    void updateTaskStatus(int id, Status status) throws TaskNotFoundException;
    List<Task> getAllTasks();
    Optional<Task> searchTaskById(int id);
}
