package com.frodo.emberwar.domain.spi;

import com.frodo.emberwar.domain.GameWorld;

public interface WorldLoaderPort {
    GameWorld loadWorld(WorldSource source);
}