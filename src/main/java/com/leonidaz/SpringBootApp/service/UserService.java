package com.leonidaz.SpringBootApp.service;

import com.leonidaz.SpringBootApp.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDetails loadUserByUsername(String firstName);

    User findById(Long id);

    List<User> allUsers();

    void save(User user);

    void edit(Long id, User user);

    void delete(Long id);

    User findByName(String firstname);

}
