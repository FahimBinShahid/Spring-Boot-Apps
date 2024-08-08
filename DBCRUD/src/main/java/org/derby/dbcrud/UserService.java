package org.derby.dbcrud;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class UserService {


    private List<User> users = new CopyOnWriteArrayList<>(
            List.of(
                    new User("37", "Spring", "SpringMVC", "hh@hh.com", "0137", "Dhaka")
            ));

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(String id) {
        return users.stream().filter(u->u.equals(id)).findFirst().orElse(null);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void updateUser(String id, User user) {
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (u.equals(id)) {
                users.set(i, user);
                return;
            }
        }

        throw new RuntimeException("User with id " + id + " not found");
    }

    public void deleteUser(String id) {
        boolean removed = users.removeIf(u -> u.equals(id));
        if (!removed) {

            throw new RuntimeException("User with id " + id + " not found");
        }
    }
}
