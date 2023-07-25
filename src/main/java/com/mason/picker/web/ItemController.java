package com.mason.picker.web;

import com.mason.picker.entity.Item;
import com.mason.picker.service.ItemService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @ApiResponse(responseCode = "200", description = "Successful retrieval of item")
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.getItem(id), HttpStatus.OK);
    }

    @ApiResponse(responseCode = "201", description = "Successful creation of item")
    @PostMapping
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.saveItem(item), HttpStatus.CREATED);
    }

    @ApiResponse(responseCode = "201", description = "Successful creation of item under user")
    @PostMapping("/user/{userId}")
    public ResponseEntity<Item> saveUserItem(@PathVariable Long userId, @RequestBody Item item) {
        return new ResponseEntity<>(itemService.saveUserItem(userId, item), HttpStatus.CREATED);
    }

    @ApiResponse(responseCode = "204", description = "Successful deletion of item")
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
