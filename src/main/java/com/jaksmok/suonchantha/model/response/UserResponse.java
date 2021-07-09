package com.jaksmok.suonchantha.model.response;

public class UserResponse {
    private Long id;
    private String username;
    private String authorities;

    public UserResponse() {
    }

    public UserResponse(Long id, String username, String authorities) {
        this.id = id;
        this.username = username;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
