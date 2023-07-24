package com.mason.picker.service;

import com.mason.picker.entity.Item;
import com.mason.picker.entity.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    List<User> getUsers();
    Item pickItem(Long id);
}
