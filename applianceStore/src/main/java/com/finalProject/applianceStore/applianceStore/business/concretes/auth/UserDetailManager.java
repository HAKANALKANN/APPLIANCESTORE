package com.finalProject.applianceStore.applianceStore.business.concretes.auth;

import com.finalProject.applianceStore.applianceStore.config.UserInfoConfig;
import com.finalProject.applianceStore.applianceStore.dataaccess.UserRepository;
import com.finalProject.applianceStore.applianceStore.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import java.util.Optional;
@Component
public class UserDetailManager implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public UserDetailManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);


        return user.map(UserInfoConfig::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
