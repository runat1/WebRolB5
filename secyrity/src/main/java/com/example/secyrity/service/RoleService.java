package com.example.secyrity.service;

import com.example.secyrity.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;
public interface RoleService {
    Role getRoleByName(String name);
    List<Role> getListOfRoles();
}
