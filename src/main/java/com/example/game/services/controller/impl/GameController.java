package com.example.game.services.controller;


import com.example.game.services.commons.entities.Game;
import com.example.game.services.services.GameServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class GameController implements GameApi {
        private final GameServices gameServices;

    public GameController(GameServices gameServices) {
        this.gameServices = gameServices;
    }


    @PostMapping
    public ResponseEntity<String> createGame(@RequestBody Game game) {
        Game gameCreated = this.gameServices.saveGame(game);

        return ResponseEntity.ok("Game created" + gameCreated);
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        var response = this.gameServices.listGame();
        return ResponseEntity.ok(response);
    }




    
}
