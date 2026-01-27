package com.frodo.emberwar.infrastructure.out.file;

import com.frodo.emberwar.domain.spi.WorldSource;
import com.frodo.emberwar.domain.spi.WorldSourceFactory;
import org.springframework.stereotype.Component;

@Component
public class JsonWorldSourceFactory implements WorldSourceFactory {
    @Override
    public WorldSource createFrom() {
        return new JsonWorldSource();
    }
}