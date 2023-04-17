package com.example.secyrity.controller;

import com.example.secyrity.model.Role;
import com.example.secyrity.model.User;
import com.example.secyrity.service.RoleService;
import com.example.secyrity.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;


    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;

    }

    @GetMapping
    public String getAdminPage(Model model, Principal principal, User user) {
        model.addAttribute("user", userService.getUserByUsername(principal.getName()));
        model.addAttribute("users", userService.getListOfUsers());
        model.addAttribute("listRoles", roleService.getListOfRoles());
        model.addAttribute("newUser", new User());
        return "index";
    }




    @PostMapping
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }
    @PostMapping("/addNewAdminUser")
    public String addNewAdminUser(@ModelAttribute("user") User user, Parameter parameter) {
        List<Role> listRoles = new ArrayList<>();
        for (Role role : user.getRoles()) {
            listRoles.add(roleService.getRoleByName("ROLE_"+role.getName()));
        }
        user.setRoles(listRoles);
        userService.addUser(user);

        return "redirect:/admin";
    }
    @GetMapping("user-delete/{id}")
    public String deleteUsers(@PathVariable("id") int id){
        userService.deleteUserById(id);
        return "redirect:/admin";
    }


    @PostMapping("/createNewUser")
    public String createUser(@ModelAttribute("newUser") User user) {
        List<Role> listRoles = new ArrayList<>();
        for (Role role : user.getRoles()) {
            listRoles.add(roleService.getRoleByName(role.getName()));
        }
        user.setRoles(listRoles);
        userService.addUser(user);
        return "redirect:/admin";
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
    @PatchMapping("/editUser")
    public String updateUser(User user) {
        List<Role> listRoles = new ArrayList<>();
        for (Role role : user.getRoles()) {
            listRoles.add(roleService.getRoleByName(role.getName()));
        }
        user.setRoles(listRoles);
        userService.updateUser(user);
        return "redirect:/admin";
    }

}
