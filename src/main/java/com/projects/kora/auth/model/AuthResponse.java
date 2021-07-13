package com.projects.kora.auth.model;

public class AuthResponse {

    private final String authToken;

    public AuthResponse(String authToken) {
        this.authToken = authToken;
    }

    public String getToken() {
        return this.authToken;
    }
}
