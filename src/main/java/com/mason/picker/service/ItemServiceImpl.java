package com.mason.picker.service;

import com.mason.picker.entity.Item;
import com.mason.picker.repository.ItemRepository;
import com.mason.picker.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    UserRepository userRepository;
    ItemRepository itemRepository;

    @Override
    public Item getItem(Long itemId) {
        return null;
    }

    @Override
    public Item saveItem(Item item) {
        return null;
    }

    @Override
    public void deleteItem(Long userId, Long itemId) {

    }

    @Override
    public Item updateItem(Long userId, Long itemId, String newName) {
        return null;
    }

    @Override
    public List<Item> getItems() {
        return null;
    }

    @Override
    public List<Item> getUserItems(Long userId) {
        return null;
    }
}
