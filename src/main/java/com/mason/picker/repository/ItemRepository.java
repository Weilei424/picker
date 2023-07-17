package com.mason.picker.repository;

import com.mason.picker.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByUserId(Long userId);

}
