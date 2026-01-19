package com.frodo.emberwar.infrastructure.web.in;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Driver adapter
 */
@Controller
@RequestMapping("/game")
public class GamePageController {

    @GetMapping
    public String gamePage() {
        // Just return the Thymeleaf template (game.html)
        return "game";
    }
}