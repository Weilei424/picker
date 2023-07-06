package com.mason.picker.service;

import com.mason.picker.entity.User;

public interface UserService {
    User getUser(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    User updateUser(Long id, User user);
}
