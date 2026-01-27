package com.frodo.emberwar.domain.service;

import com.frodo.emberwar.domain.GameWorld;
import com.frodo.emberwar.domain.api.StartGameUseCasePort;
import com.frodo.emberwar.domain.spi.WorldLoaderPort;
import com.frodo.emberwar.domain.spi.WorldSource;
import com.frodo.emberwar.domain.spi.WorldSourceFactory;
import org.springframework.stereotype.Service;

@Service
public class StartGameUseCaseImpl implements StartGameUseCasePort {

    private final WorldLoaderPort worldLoader;
    private final WorldSourceFactory worldSourceFactory;


    public StartGameUseCaseImpl(WorldLoaderPort worldLoader, WorldSourceFactory worldSourceFactory) {
        this.worldLoader = worldLoader;
        this.worldSourceFactory = worldSourceFactory;
    }

    @Override
    public GameWorld start() {
        // Use the factory to create a domain-agnostic WorldSource
        // “Agnostic” literally means “doesn’t know about / is independent of”.
        WorldSource worldSource = worldSourceFactory.createFrom();

        try {
            return worldLoader.loadWorld();
        } catch (Exception e) {
            throw new RuntimeException("Failed to start game world");
        }
    }
}
