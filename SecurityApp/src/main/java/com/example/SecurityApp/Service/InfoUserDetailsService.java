package com.example.SecurityApp.Service;

import com.example.SecurityApp.Configuration.InfoUserDetails;
import com.example.SecurityApp.Model.Info;
import com.example.SecurityApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Info> userInfo = repo.findByName(username);

        return userInfo.map(InfoUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("User Not Found : " + username));
    }
}
