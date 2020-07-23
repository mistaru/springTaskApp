package kg.demir.taskapp.service;

import kg.demir.taskapp.entity.Task;

import java.util.List;

public interface ITaskService {

    void save(Task task);

    Task update(Task task);

    void deleteById(Long id);

    List<Task> findAll();

    Task get(Long id);
}
