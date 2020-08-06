package com.rokomari.demo.security;

import com.rokomari.demo.domain.User;
import com.rokomari.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("MyUserDetailsService -> " + username);
        User user = repo.findByUsername(username);

        if (user == null) throw new UsernameNotFoundException("User not found");

        System.out.println("MyUserDetailsService USER -> " + user);
        return new UserPrincipal(user);
    }
}
