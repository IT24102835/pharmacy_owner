package com.pms.pharmacymanagement.service;

import com.pms.pharmacymanagement.model.Staff;
import com.pms.pharmacymanagement.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = staffRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        if (!staff.isActive()) {
            throw new UsernameNotFoundException("User account is disabled: " + username);
        }

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + staff.getRole());

        return new User(staff.getUsername(), staff.getPassword(), Collections.singleton(authority));
    }
}