package com.frodo.emberwar.infrastructure.in.web;

import com.frodo.emberwar.domain.GameWorld;
import com.frodo.emberwar.application.api.StartGameUseCasePort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Driver adapter for the web browser thymeleaf
 */
@Controller
@RequestMapping("/game")
public class ThymeleafController {

    private final StartGameUseCasePort startGame;

    public ThymeleafController(StartGameUseCasePort startGame) {
        this.startGame = startGame;
    }

    @GetMapping
    public String gamePage(Model model) {
        GameWorld world = startGame.start();  // generate your game world
        model.addAttribute("world", world);   // <-- add it to the model
        return "game";                        // Thymeleaf template name
    }
}