package com.example.jwt_auth.service;

import com.example.jwt_auth.dto.UserRequest;
import com.example.jwt_auth.entity.User;
import com.example.jwt_auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;


    @Override
    @Transactional
    public void save(UserRequest userRequest) {
        userRequest.setPassword(encoder.encode(userRequest.getPassword()));
        User entity = userRequest.toEntity();

        userRepository.save(entity);
    }
}
