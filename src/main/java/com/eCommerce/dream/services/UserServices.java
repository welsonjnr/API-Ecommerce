package com.eCommerce.dream.services;

import com.eCommerce.dream.domain.User;
import com.eCommerce.dream.dto.user.UserNewDTO;
import com.eCommerce.dream.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    public User save(UserNewDTO objDto) {
        User user = new User(null, objDto.getLogin(), objDto.getEmail(),
                new BCryptPasswordEncoder().encode(objDto.getKey()));
        repository.save(user);
        return user;
    }

}
