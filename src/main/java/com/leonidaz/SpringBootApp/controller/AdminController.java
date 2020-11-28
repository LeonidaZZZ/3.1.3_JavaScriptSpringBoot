package com.leonidaz.SpringBootApp.controller;

import com.leonidaz.SpringBootApp.model.Role;
import com.leonidaz.SpringBootApp.model.User;
import com.leonidaz.SpringBootApp.repository.UserRepository;
import com.leonidaz.SpringBootApp.service.RoleService;
import com.leonidaz.SpringBootApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.Set;
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping()
    public String allUsers(Model model){
        model.addAttribute("users", userService.allUsers());
        return "admin/all_users";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("ADMIN", true);
        model.addAttribute("USER",true);
        model.addAttribute("user", new User());
        return "admin/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user,
                         @RequestParam(value = "ADMIN", required = false) boolean adminCheck,
                         @RequestParam(value = "USER", required = false) boolean userCheck) {
        Set<Role> roles = new HashSet<>();
        if (adminCheck)
            roles.add(roleService.findById(2L));
        if (userCheck)
            roles.add(roleService.findById(1L));
        user.setRoles(roles);
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,
                       @PathVariable("id") Long id,
                       @RequestParam(value = "ADMIN", required = false) boolean adminCheck,
                       @RequestParam(value = "USER", required = false) boolean userCheck) {
        model.addAttribute("ADMIN", adminCheck);
        model.addAttribute("USER", userCheck);
        model.addAttribute("user", userService.findById(id));
        return "admin/edit";
    }

    @PostMapping("/{id}")
    public String editPerson(@ModelAttribute("user") User user,
                             @PathVariable("id") Long id,
                             @RequestParam(value = "ADMIN", required = false) boolean adminCheck,
                             @RequestParam(value = "USER", required = false) boolean userCheck) {
        Set<Role> roles = new HashSet<>();
        if (adminCheck)
            roles.add(roleService.findById(2L));
        if (userCheck)
            roles.add(roleService.findById(1L));
        user.setRoles(roles);
        userService.edit(id, user);
        return "redirect:/admin";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
