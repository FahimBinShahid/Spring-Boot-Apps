package com.todo.todoapp.Repository;

import com.todo.todoapp.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
