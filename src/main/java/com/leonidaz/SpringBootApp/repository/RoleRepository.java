package com.leonidaz.SpringBootApp.repository;


import com.leonidaz.SpringBootApp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
