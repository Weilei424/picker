package com.mason.picker.service;

import com.mason.picker.entity.Item;

import java.util.List;

public interface ItemService {
    Item getItem(Long itemId);
    Item saveItem(Item item);
    void deleteItem(Long userId, Long itemId);
    Item updateItem(Long userId, Long itemId, String newName);
    List<Item> getItems();
    List<Item> getUserItems(Long userId);
}
