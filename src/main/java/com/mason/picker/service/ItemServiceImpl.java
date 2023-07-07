package com.mason.picker.service;

import com.mason.picker.entity.Item;
import com.mason.picker.exception.ItemNotFoundException;
import com.mason.picker.repository.ItemRepository;
import com.mason.picker.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    UserRepository userRepository;
    ItemRepository itemRepository;

    @Override
    public Item getItem(Long itemId) {
        return itemRepository.findById(itemId).get();
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }



    @Override
    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }

    @Override
    public void deleteUserItem(Long userId, Long itemId) {
        List<Item> items = itemRepository.findByUserId(userId);
        for (Item item : items) {
            if (item.getId() == itemId)
                deleteItem(itemId);
        }
        throw new ItemNotFoundException(userId);
    }

    @Override
    public Item updateItem(Long userId, Long itemId, String itemName) {
        List<Item> items = itemRepository.findByUserId(userId);
        for (Item item : items) {
            if (item.getId() == itemId) {
                item.setName(itemName);
                return itemRepository.save(item);
            }
        }
        throw new ItemNotFoundException(userId);
    }

    @Override
    public List<Item> getItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public List<Item> getUserItems(Long userId) {
        return itemRepository.findByUserId(userId);
    }

    private static Item unwrapItem(Optional<Item> entity, Long userId) {
        if (entity.isPresent()) return entity.get();
        else throw new ItemNotFoundException(userId);
    }
}
