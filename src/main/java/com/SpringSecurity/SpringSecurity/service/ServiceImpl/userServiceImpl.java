package com.SpringSecurity.SpringSecurity.service.ServiceImpl;

import com.SpringSecurity.SpringSecurity.entity.Users;
import com.SpringSecurity.SpringSecurity.repository.UserRepo;
import com.SpringSecurity.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }


}
