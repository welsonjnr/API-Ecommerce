package com.eCommerce.dream.config.security;

import com.eCommerce.dream.domain.User;
import com.eCommerce.dream.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    public UserService() {
    }

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = repository.findByLogin(login);
        return (!user.isPresent()) ?
                user.orElseThrow(() -> new UsernameNotFoundException("User data not found")) :
                user.get();
    }

    public String singUpUser(User user){
        return null;
    }
}
