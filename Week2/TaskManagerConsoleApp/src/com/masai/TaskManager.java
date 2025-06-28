package com.masai;

import java.util.*;
import java.util.stream.Collectors;

public class TaskManager implements TaskOperations{

    private List<Task> taskList = new ArrayList<>();
    private Map<Integer, Task> taskMap = new HashMap<>();

    @Override
    public void addTask(Task task) {
        taskList.add(task);
        taskMap.put(task.getId(), task);
    }

    @Override
    public void removeTask(int id) {
        taskList.remove(id);
    }

    @Override
    public void updateTaskStatus(int id, Status status) throws TaskNotFoundException {
        Task task = taskMap.get(id);
        if (task == null) throw new TaskNotFoundException("No task found with id: " + id);
        task.setStatus(status);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskList;
    }

    @Override
    public Optional<Task> searchTaskById(int id) {
        return Optional.ofNullable(taskMap.get(id));
    }

    public List<Task> filterByStatus(Status status) {
        return taskList.stream()
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
    }


    public List<Task> sortByDueDate() {
        return taskList.stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .collect(Collectors.toList());
    }
}
