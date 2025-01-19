package com.exercise.crud.config;

import com.exercise.crud.model.User;
import com.exercise.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findUserByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found with name : " + username));
        return new org.springframework.security.core.userdetails.
                User(user.getName(), "{noop}" + user.getPassword(), getRoles(user));
    }

    private Set<GrantedAuthority> getRoles(User user) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        return Set.of(authority);
    }
}
