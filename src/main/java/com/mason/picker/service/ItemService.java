package com.mason.picker.service;

import com.mason.picker.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item getItem(Long itemId);
    Item saveItem(Item item);
    void deleteItem(Long itemId);
    void deleteUserItem(Long userId, Long itemId);
    Item updateItem(Long userId, Long itemId, String itemName);
    List<Item> getItems();
    List<Item> getUserItems(Long userId);
}
