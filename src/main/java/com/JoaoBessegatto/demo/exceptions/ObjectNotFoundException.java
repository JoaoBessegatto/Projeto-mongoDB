package com.JoaoBessegatto.demo.exceptions;

public class ObjectNotFoundException extends BaseException {
    public ObjectNotFoundException(String message) {
        super(message, 404);
    }
}
