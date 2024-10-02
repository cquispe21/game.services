package com.example.game.services.controller;


import com.example.game.services.entities.Game;
import com.example.game.services.repository.GameRepository;
import com.example.game.services.services.GameServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
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

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        var response = this.gameServices.getGameById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game game) {
        var response = this.gameServices.updateGame(id, game);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable Long id) {
        this.gameServices.deleteGame(id);
        return ResponseEntity.ok("Game deleted");
    }
    
}
