package com.leonidaz.SpringBootApp.service;

import com.leonidaz.SpringBootApp.model.Role;

import java.util.List;

public interface RoleService {
    Role findById(Long id);
    List<Role> findAll();
}
