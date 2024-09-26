package com.casa.mongospring.service.exception;

import lombok.Getter;

@Getter
public class ObjectNotFoundException extends RuntimeException {
    private final String id;

    public ObjectNotFoundException(String msg, String id) {
        super(msg);
        this.id = id;
    }
}
