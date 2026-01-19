package com.frodo.emberwar.domain.api;

import com.frodo.emberwar.domain.GameWorld;

public interface StartGameUseCasePort {
    GameWorld start(String source);
}
