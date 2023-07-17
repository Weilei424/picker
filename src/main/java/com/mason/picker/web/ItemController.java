package com.mason.picker.web;

import com.mason.picker.entity.Item;
import com.mason.picker.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/item")
public class ItemController {
    ItemService itemService;

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.getItem(id), HttpStatus.OK);
    }

    @PostMapping("/{itemId}/user/{userId}")
    public ResponseEntity<Item> saveItem(@PathVariable Long userId, @PathVariable Long itemId, @RequestBody Item item) {
        return new ResponseEntity<>(itemService.saveItem(userId, itemId, item), HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/{itemId}")
    public ResponseEntity<HttpStatus> deleteUserItem(@PathVariable Long userId, @PathVariable Long itemId) {
        itemService.deleteUserItem(userId, itemId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{userId}/{itemId}")
    public ResponseEntity<Item> updateItem(@PathVariable Long userId, @PathVariable Long itemId, @RequestBody String itemName) {
        itemService.updateItem(userId, itemId, itemName);

        return new ResponseEntity<>(itemService.getItem(itemId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getItems() {
        return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK);
    }

    @GetMapping("/{userId}/all")
    public ResponseEntity<List<Item>> getUserItems(@PathVariable Long userId) {
        return new ResponseEntity<>(itemService.getUserItems(userId), HttpStatus.OK);
    }
}
