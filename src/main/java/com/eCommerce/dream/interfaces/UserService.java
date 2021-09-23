package com.eCommerce.dream.interfaces;

import com.eCommerce.dream.domain.Role;
import com.eCommerce.dream.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String login, String roleName);
    User getUser(String login);
    List<User> getUsers();

}
