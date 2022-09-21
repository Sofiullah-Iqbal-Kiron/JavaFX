package com.login_subsystem;

public class LoginData {
    private String username;
    private String password;

    LoginData(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
