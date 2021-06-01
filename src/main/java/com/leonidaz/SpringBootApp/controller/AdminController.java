package com.leonidaz.SpringBootApp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String showAdminHtml(){
        return "admin/all_users";
    }


    @GetMapping
    public void meth(){return;}
}
