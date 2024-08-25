package com.todo.todoapp.Service;
import com.todo.todoapp.Model.Task;
import com.todo.todoapp.Repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public Task getTaskById(int id) {
        return taskRepository.findById(id).get();
    }
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }


    public void deleteTask(int id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);

        } else {
            throw new NoSuchElementException("Task with id " + id + " not found");
        }
    }


    public Task updateTask(int id, Task task) {

        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setPriority(task.getPriority());
            existingTask.setStatus(task.getStatus());
            return taskRepository.save(existingTask);
        } else {
            throw new NoSuchElementException("Task with id " + id + " not found");
        }
    }

}

