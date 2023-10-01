package ru.javarush.pyshnyi.crypto.exceptions;

public class CryptoExceptions extends RuntimeException{
    public CryptoExceptions() {
    }

    public CryptoExceptions(String message) {
        super(message);
    }

    public CryptoExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public CryptoExceptions(Throwable cause) {
        super(cause);
    }
}
