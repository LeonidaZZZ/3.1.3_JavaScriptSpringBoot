package com.leonidaz.SpringBootApp.service;

import com.leonidaz.SpringBootApp.model.Role;
import com.leonidaz.SpringBootApp.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findById(Long id){
        return roleRepository.findById(id).orElseThrow();
    }
    public List<Role> findAll(){
        return roleRepository.findAll();
    }

}
