package kg.demir.taskapp.service.Impl;

import kg.demir.taskapp.entity.Task;
import kg.demir.taskapp.enums.Status;
import kg.demir.taskapp.repository.TaskRepository;
import kg.demir.taskapp.service.ITaskService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements ITaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(@NotNull TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void save(Task task) {
        task.setStartDate(LocalDate.now());
        task.setStatus(Status.NOT_STARTED);
        taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        task.setStartDate(LocalDate.now());
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task get(Long id) {
        return taskRepository.getOne(id);
    }
}
