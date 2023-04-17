
package com.example.secyrity.service;


import com.example.secyrity.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    User getUserById(int id);
    List<User> getListOfUsers();
    void addUser(User user);
    void deleteUserById(int id);
    void updateUser(User user);
}
