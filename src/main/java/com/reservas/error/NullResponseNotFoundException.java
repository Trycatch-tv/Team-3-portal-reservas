package com.reservas.error;

public class NullResponseNotFoundException extends Exception{
    public NullResponseNotFoundException(String message) {
        super(message);
    }
}
