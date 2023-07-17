package com.mason.picker.repository;

import com.mason.picker.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User, Long> {
}
