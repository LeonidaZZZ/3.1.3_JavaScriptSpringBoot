package com.leonidaz.SpringBootApp.service;

import com.leonidaz.SpringBootApp.model.Role;

public interface RoleService {
    Role findById(Long id);
}
