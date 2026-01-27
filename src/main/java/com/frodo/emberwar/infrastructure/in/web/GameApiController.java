package com.frodo.emberwar.infrastructure.in.web;

import com.frodo.emberwar.domain.GameWorld;
import com.frodo.emberwar.domain.api.StartGameUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Driver adapter
 */
@RestController
@RequestMapping("/api/game/")
public class GameApiController {

    private final StartGameUseCasePort startGame;

    public GameApiController(StartGameUseCasePort startGame) {
        this.startGame = startGame;
    }

    @PostMapping
    public ResponseEntity<GameWorld> startGame() {
        try {
            GameWorld world = startGame.start();
            return ResponseEntity.ok(world);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
