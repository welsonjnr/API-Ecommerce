package com.eCommerce.dream.services;

import com.eCommerce.dream.domain.Role;
import com.eCommerce.dream.domain.User;
import com.eCommerce.dream.interfaces.UserService;
import com.eCommerce.dream.repository.RoleRepository;
import com.eCommerce.dream.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service @Slf4j
public class UserServices implements UserService, UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository repositoryRole;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return repositoryRole.save(role);
    }

    @Override
    public void addRoleToUser(String login, String roleName) {
        User user = repository.findByUsername(login);
        Optional<Role> role = repositoryRole.findByName(roleName);
        user.getRoles().add(role.get());
    }

    @Override
    public User getUser(String login) {
        return repository.findByUsername(login);
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = repository.findByUsername(login);
        if(user == null){
            log.error("User no found in the database");
            throw  new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", login);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> { authorities.add(new SimpleGrantedAuthority(role.getName())); });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
