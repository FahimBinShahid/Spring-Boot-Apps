package com.todo.todoapp.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String jobTitle;
    private String password;
    private String phone;

    @JsonBackReference
    @ManyToMany(mappedBy = "users")
    private List<Task> tasks = new ArrayList<>();
}
