package edu.store.service.impl;

import edu.store.entity.UserAccount;
import edu.store.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DefaultUserDetailsServiceImpl implements UserDetailsService, UserDetailsServiceImpl {

    private final DefaultUserService userService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        UserAccount userAccount = userService.findByEmail(email);
        if (userAccount == null)
            throw new UsernameNotFoundException(email + " not found");

        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(userAccount.getRole().toString()));

        return new User(userAccount.getEmail(), userAccount.getPassword(), roles);
    }
}