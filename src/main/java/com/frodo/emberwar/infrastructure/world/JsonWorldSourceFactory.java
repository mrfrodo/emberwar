package com.frodo.emberwar.infrastructure.world;

import com.frodo.emberwar.domain.spi.WorldSource;
import com.frodo.emberwar.domain.spi.WorldSourceFactory;
import org.springframework.stereotype.Component;

@Component
public class JsonWorldSourceFactory implements WorldSourceFactory {
    @Override
    public WorldSource createFrom(String sourceId) {
        return new JsonWorldSource(sourceId);
    }
}