package com.frodo.emberwar.application.spi;

/**
 * Domain-level exception for world loading failures.
 * Infrastructure exceptions (IO, JSON, etc) are wrapped in this.
 */
public class WorldLoadingException extends RuntimeException {

    public WorldLoadingException(String message) {
        super(message);
    }

    public WorldLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
