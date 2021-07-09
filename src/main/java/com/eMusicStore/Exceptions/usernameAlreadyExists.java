package com.eMusicStore.Exceptions;

public class usernameAlreadyExists extends RuntimeException {
    public usernameAlreadyExists(String message) {
        super(message);
    }
}
