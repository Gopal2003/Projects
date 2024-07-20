package com.smart.config;

import com.smart.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.doa.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        //fetching user from the database

        User user =  userRepository.getUserByUserName(username);

        if(user == null)
        {
            throw new UsernameNotFoundException("User '"+username+"' not found.");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(user);
       
        return customUserDetails;
    }

}
