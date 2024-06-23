package com.shop.domain;

public class User {
    private String username;
    private String password;
    private String name;
    private String address;
    private String email;

    public User(String username, String password, String name, String address, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    // Getters and Setters (생략)
}
