package com.mason.picker.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long userId, Long itemId) {
        super("Couldn't find item#" + itemId + " in user#" + userId);
    }
}
