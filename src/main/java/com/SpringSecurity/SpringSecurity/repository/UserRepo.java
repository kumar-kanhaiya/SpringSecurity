package com.SpringSecurity.SpringSecurity.repository;

//import com.SpringSecurity.SpringSecurity.entity.User;
import com.SpringSecurity.SpringSecurity.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);

}
