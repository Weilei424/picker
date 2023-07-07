package com.mason.picker.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long userId) {
        super("Couldn't find item in user#" + userId);
    }
}
