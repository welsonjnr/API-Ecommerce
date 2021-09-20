package com.eCommerce.dream.dto.user;

import javax.validation.constraints.*;

public class UserNewDTO {

    @NotBlank(message = "Login cannot be empty")
    @Size(min = 6, max = 14, message = "Login must be between 6 and 14 characters.")
    private String login;
    @Email
    @NotNull(message = "Email cannot be empty")
    private String email;
    @NotBlank
    @Size(min = 6, max = 14, message = "The key must be between 6 and 14 characters.")
    private String key;

    public UserNewDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
