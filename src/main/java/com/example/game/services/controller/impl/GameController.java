package com.example.game.services.controller.impl;


import com.example.game.services.commons.entities.Game;
import com.example.game.services.controller.GameApi;

import com.example.game.services.services.impl.GameServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class GameController implements GameApi {
        private final GameServices gameServices;

    public GameController(GameServices gameServices) {
        this.gameServices = gameServices;
    }

    @Override
    public ResponseEntity<String> createGame(@RequestBody Game game) {
        Game gameCreated = this.gameServices.saveGame(game);

        return ResponseEntity.ok("Game created" + gameCreated);
    }

    @Override
    public ResponseEntity<Game> getGameById(Long id) {
        Game game = this.gameServices.getGameById(id);
        return ResponseEntity.ok(game);
    }

    @Override
    public ResponseEntity<String> updateGame(Game game) {
        var res = this.gameServices.updateGame(game);
        return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<String> deleteGame(Long id) {
        var res = this.gameServices.deleteGame(id);
        return ResponseEntity.ok(res);
    }

}
