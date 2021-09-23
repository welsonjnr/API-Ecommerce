package com.eCommerce.dream.dto.user;

import javax.validation.constraints.NotBlank;

public class RoleToUserForm{
    @NotBlank
    private String login;
    @NotBlank
    private String roleName;

    public RoleToUserForm() { }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}