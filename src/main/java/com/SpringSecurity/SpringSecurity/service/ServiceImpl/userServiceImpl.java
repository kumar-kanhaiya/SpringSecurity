package com.SpringSecurity.SpringSecurity.service.ServiceImpl;

import com.SpringSecurity.SpringSecurity.entity.Users;
import com.SpringSecurity.SpringSecurity.repository.UserRepo;
import com.SpringSecurity.SpringSecurity.service.JWTService;
import com.SpringSecurity.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private JWTService service;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public String verify(Users users) {
        Authentication authentication = authManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(users.getUsername() , users.getPassword()));

        if(authentication.isAuthenticated()){
            return service.generateToken(users.getUsername());
        }
        return "Failure";
    }


}
