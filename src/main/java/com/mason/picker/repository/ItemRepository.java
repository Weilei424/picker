package com.mason.picker.repository;

import com.mason.picker.entity.Item;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Optional<Item> findByUserIdAndItemId(Long userId, Long ItemId);
    @Transactional
    void deleteByUserIdAndItemId(Long userId, Long ItemId);
    List<Item> findByUserId(Long userId);
}
