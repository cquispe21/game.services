package com.example.game.services.services;

import com.example.game.services.entities.Game;
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
    
    public Game getGameById(Long id){
        var response = this.gameRepository.findById(id).orElseThrow();
        return response;
    }

    public Game updateGame(Long id, Game game){
        var gameUpdate = this.gameRepository.findById(id).orElseThrow();
   gameUpdate.setGameName(null != game.getGameName() ? game.getGameName() : gameUpdate.getGameName());

        var response = this.gameRepository.save(gameUpdate);
    }
}
