
package com.example.secyrity.dao;


import com.example.secyrity.model.User;
import org.springframework.data.jpa.repository.Query;

import java.beans.Transient;
import java.util.List;

public interface UserDao {

    void addUser(User user);

    void deleteUserById(int id);

    void updateUser(User user);

    User getUserById(int id);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    List<User> getListOfUsers();
}