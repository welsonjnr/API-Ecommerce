package com.eCommerce.dream.dto.user;

import com.eCommerce.dream.domain.User;

public class UserDTO {

    private String login;
    private String key;
    private String email;

    public UserDTO(User user) {
        this.login = user.getLogin();
        this.key = user.getKey();
        this.email = user.getEmail();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
