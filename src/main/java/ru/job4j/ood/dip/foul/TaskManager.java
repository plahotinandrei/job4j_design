package ru.job4j.ood.dip.foul;

/* Нарушает принцип DIP, так как класс зависит от конкретной реализации SimpleTaskRepository
через композицию. */
public class TaskManager {

    private final SimpleTaskRepository taskRepository;

    public TaskManager() {
        this.taskRepository = new SimpleTaskRepository();
    }

    public void addTask(Task task) {
        taskRepository.add(task);
    }
}
