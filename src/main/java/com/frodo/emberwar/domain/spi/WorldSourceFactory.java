package com.frodo.emberwar.domain.spi;

/**
 * Domain-level factory for creating WorldSource instances.
 * Keeps the application and domain layers independent of infrastructure.
 */
public interface WorldSourceFactory {
    WorldSource createFrom();
}