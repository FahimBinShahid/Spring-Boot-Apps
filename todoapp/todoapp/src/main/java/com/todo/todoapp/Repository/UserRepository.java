package com.todo.todoapp.Repository;

import com.todo.todoapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByTasksId(Long taskId);

    @Override
    Optional<User> findById(Long id);
}
