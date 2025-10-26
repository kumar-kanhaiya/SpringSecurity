package com.SpringSecurity.SpringSecurity.service;

import com.SpringSecurity.SpringSecurity.entity.UserPrincipal;
import com.SpringSecurity.SpringSecurity.entity.Users;
import com.SpringSecurity.SpringSecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepo.findByUsername(username);

        if(user == null){
            System.out.println("User not found ");
            throw new UsernameNotFoundException("User not found ");
        }

        return new UserPrincipal(user);
    }
}
