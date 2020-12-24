package com.leonidaz.SpringBootApp.controller;

import com.leonidaz.SpringBootApp.model.User;
import com.leonidaz.SpringBootApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/u")
public class UserRestController {
    private final UserService userService;


    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<User> showById(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(userService.findByName(auth.getName()), HttpStatus.OK);
    }
}
