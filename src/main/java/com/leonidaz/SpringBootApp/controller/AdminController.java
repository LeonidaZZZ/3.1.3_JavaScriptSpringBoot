package com.leonidaz.SpringBootApp.controller;

import com.leonidaz.SpringBootApp.model.Role;
import com.leonidaz.SpringBootApp.model.User;
import com.leonidaz.SpringBootApp.repository.RoleRepository;
import com.leonidaz.SpringBootApp.service.RoleService;
import com.leonidaz.SpringBootApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        String role = user.getRoles().iterator().next().getAuthority();
        model.addAttribute("roleSet", roleService.findAll());
        model.addAttribute("admin", user);
        model.addAttribute("role", role);
        return "admin/all_users";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @PostMapping("/{id}")
    public String editPerson(@ModelAttribute("user") User user,
                             @PathVariable("id") Long id) {
        userService.edit(id, user);
        return "redirect:/admin";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
