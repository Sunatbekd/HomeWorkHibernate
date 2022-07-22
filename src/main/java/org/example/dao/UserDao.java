package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDao {

    void dropUsersTable();

    void saveUser(User user);

    User getById(Long id);

    void removeUserById(Long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
