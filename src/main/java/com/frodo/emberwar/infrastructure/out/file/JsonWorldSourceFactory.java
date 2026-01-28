package com.frodo.emberwar.infrastructure.out.file;

import com.frodo.emberwar.application.spi.WorldSource;
import com.frodo.emberwar.application.spi.WorldSourceFactory;
import org.springframework.stereotype.Component;

@Component
public class JsonWorldSourceFactory implements WorldSourceFactory {
    @Override
    public WorldSource createFrom() {
        return new JsonWorldSource();
    }
}