package com.projects.kora.auth.service;

import com.projects.kora.auth.model.UserDAO;
import com.projects.kora.auth.model.UserDTO;
import com.projects.kora.auth.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDAO user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found with username:" + username);
        }
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    public int getUserIdByUsername(String username) throws UsernameNotFoundException {
        UserDAO user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found with username:" + username);
        }
        return user.getUserId();
    }

    public UserDTO saveUser(UserDTO user) {
        UserDAO newUser = dtoToDao(user);
        return daoToDto(userRepository.save(newUser));

    }

    private UserDAO dtoToDao(UserDTO user) {
        UserDAO newUser = new UserDAO();
        newUser.setUserId(user.getUserId());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setFirstName(user.getFirstName());
        newUser.setMiddleName(user.getMiddleName());
        newUser.setLastName(user.getLastName());
        newUser.setDob(user.getDob());
        newUser.setGender(user.getGender());
        return newUser;
    }

    private UserDTO daoToDto(UserDAO user) {
        UserDTO newUser = new UserDTO();
        newUser.setUserId(user.getUserId());
        newUser.setUsername(user.getUsername());
//        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setFirstName(user.getFirstName());
        newUser.setMiddleName(user.getMiddleName());
        newUser.setLastName(user.getLastName());
        newUser.setDob(user.getDob());
        newUser.setGender(user.getGender());
        return newUser;
    }
}
