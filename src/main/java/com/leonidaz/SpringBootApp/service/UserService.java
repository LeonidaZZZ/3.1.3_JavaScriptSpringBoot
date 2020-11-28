package com.leonidaz.SpringBootApp.service;

import com.leonidaz.SpringBootApp.model.User;
import com.leonidaz.SpringBootApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDetails loadUserByUsername(String firstName);

    User findById(Long id);

    public List<User> allUsers();

    public void save(User user);

    public void edit(Long id, User user);

    public void delete(Long id);

    public User findByName(String firstname);

}
