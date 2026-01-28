package com.frodo.emberwar.application.spi;

import com.frodo.emberwar.domain.GameWorld;

public interface WorldLoaderPort {
    GameWorld loadWorld();
}