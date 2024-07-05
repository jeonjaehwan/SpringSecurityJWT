package com.example.jwt_auth.service;

import com.example.jwt_auth.dto.UserRequest;

public interface UserService {

    void save(UserRequest userRequest);
}
