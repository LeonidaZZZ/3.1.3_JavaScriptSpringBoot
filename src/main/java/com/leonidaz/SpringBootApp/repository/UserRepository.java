package com.leonidaz.SpringBootApp.repository;

import com.leonidaz.SpringBootApp.model.Role;
import com.leonidaz.SpringBootApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByFirstName(String name);
}
