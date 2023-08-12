package com.example.SecurityApp.Service;

import com.example.SecurityApp.Model.Info;
import com.example.SecurityApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;


    public String newUser(Info info){
        info.setPassword(encoder.encode(info.getPassword()));
        repo.save(info);
        return "User Added...!";
    }
}
