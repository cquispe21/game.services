package com.example.game.services.controller;


import com.example.game.services.commons.constans.ApiRoutesVariables;
import com.example.game.services.commons.entities.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiRoutesVariables.V1_ROUTE + ApiRoutesVariables.GAME_ROUTE)
public interface GameApi {
    @PostMapping
    ResponseEntity<String> createGame(@RequestBody Game game);
    @GetMapping("/{id}")
    ResponseEntity<Game> getGameById(@PathVariable Long id);

    @PutMapping
    ResponseEntity<String> updateGame(@RequestBody Game game);

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteGame(@PathVariable Long id);


}
