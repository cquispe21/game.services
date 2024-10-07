package com.example.game.services.services.impl;

import com.example.game.services.commons.entities.Game;
import com.example.game.services.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServices  {
    private final GameRepository gameRepository;

    public GameServices(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    public Game saveGame (Game gameReq){
        Game gameCreateSave = this.gameRepository.save(gameReq);
        return gameCreateSave;
    }

    public List<Game> listGame (){
       var response = this.gameRepository.findAll();
       return response;
    }


}
