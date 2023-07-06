package com.mason.picker.service;

import com.mason.picker.entity.User;
import com.mason.picker.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UserServerImpl implements UserService {
    UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public User updateUser(Long id, User user) {
        return null;
    }
}
