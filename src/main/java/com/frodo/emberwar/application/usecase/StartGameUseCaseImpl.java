package com.frodo.emberwar.application.usecase;

import com.frodo.emberwar.domain.GameWorld;
import com.frodo.emberwar.application.api.StartGameUseCasePort;
import com.frodo.emberwar.application.spi.WorldLoaderPort;
import com.frodo.emberwar.application.spi.WorldSource;
import com.frodo.emberwar.application.spi.WorldSourceFactory;
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
