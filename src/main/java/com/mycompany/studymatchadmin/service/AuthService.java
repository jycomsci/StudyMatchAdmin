package com.mycompany.studymatchadmin.service;

import com.mycompany.studymatchadmin.repository.AuthRepository;

public class AuthService {

    AuthRepository repo = new AuthRepository();

    public boolean login(String username, String password) {
        return repo.login(username,password);
    }
}