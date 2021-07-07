package com.projects.kora.auth.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if("kora".equals(username)) {
            return new User("kora", "$2a$10$VH13WslwBNQe5zoOjPUzhuu0q3AGoIrOxG3JuEf3tGP8vKX9Pd3.S", new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not found with username:" + username);
        }
    }
}
