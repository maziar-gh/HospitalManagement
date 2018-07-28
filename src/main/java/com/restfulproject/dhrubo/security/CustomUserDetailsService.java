package com.restfulproject.dhrubo.security;

import com.restfulproject.dhrubo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.restfulproject.dhrubo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class CustomUserDetailsService implements UserDetailsService {

        @Autowired
        UserRepository userRepository;

        @Transactional
        public UserDetails loadUserByEmail(String email)
                throws UsernameNotFoundException {
            // Let people login with either username or email
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() ->
                            new UsernameNotFoundException("User not found with email : " + email)
                    );

            return UserPrincipal.create(user);
        }

        // This method is used by JWTAuthenticationFilter
        @Transactional
        public UserDetails loadUserById(Long id) {
            User user = userRepository.findById(id).orElseThrow(
                    () -> new UsernameNotFoundException("User not found with id : " + id)
            );

            return UserPrincipal.create(user);
        }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
