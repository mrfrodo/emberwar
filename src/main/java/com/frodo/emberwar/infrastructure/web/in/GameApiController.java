package com.frodo.emberwar.infrastructure.web.in;

import com.frodo.emberwar.domain.GameWorld;
import com.frodo.emberwar.domain.api.StartGameUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Driver adapter
 */
@RestController
@RequestMapping("/api/game")
public class GameApiController {

    private final StartGameUseCasePort startGame;

    public GameApiController(StartGameUseCasePort startGame) {
        this.startGame = startGame;
    }

    @PostMapping("/start")
    public ResponseEntity<GameWorld> startGame(@RequestBody String worldJson) {
        try {
            GameWorld world = startGame.start(worldJson);
            return ResponseEntity.ok(world);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
