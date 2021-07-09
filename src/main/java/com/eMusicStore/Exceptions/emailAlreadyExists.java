package com.eMusicStore.Exceptions;

public class emailAlreadyExists extends RuntimeException {
    public emailAlreadyExists(String message) {
        super(message);
    }
}
