package com.projects.kora.auth.model;

public class AuthRequest {

    private String username;
    private String password;

    // default constructor needed for JSON parsing
    public AuthRequest() {

    }

    public AuthRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
