package com.leonidaz.SpringBootApp.service;

import com.leonidaz.SpringBootApp.model.User;
import com.leonidaz.SpringBootApp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;


    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String firstName) {
        return userRepository.findUserByFirstName(firstName);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public List<User> allUsers(){
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void edit(Long id, User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User newUser = userRepository.findById(id).orElseThrow();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.getRoles().clear();
        newUser.setRoles(user.getRoles());
        userRepository.save(newUser);
    }
    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.delete(userRepository.findById(id).orElseThrow());
    }

    @Override
    public User findByName(String firstname) {
        return userRepository.findUserByFirstName(firstname);
    }


}
