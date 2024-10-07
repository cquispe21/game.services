package com.example.game.services.services.impl;

import com.example.game.services.commons.entities.Game;
import com.example.game.services.commons.exceptions.GameException;
import com.example.game.services.repository.GameRepository;
import com.example.game.services.services.IGameServices;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServices implements IGameServices {
    private final GameRepository gameRepository;

    public GameServices(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame (Game gameReq){
        Game gameCreateSave = this.gameRepository.save(gameReq);
        return gameCreateSave;
    }

    @Override
    public Game getGameById(Long gameId) {
        Game GamebyId = this.gameRepository.findById(gameId).orElseThrow(
                () -> new GameException("Id no existe",HttpStatus.NOT_FOUND ));
        return GamebyId;
    }

    @Override
    public String deleteGame(Long gameId) {

        Game gameToDelete = this.gameRepository.findById(gameId).orElseThrow(
                () -> new GameException("Id no existe", HttpStatus.NOT_FOUND)
        );


        this.gameRepository.deleteById(gameId);

        return "Juego eliminado correctamente.";
    }


    @Override
    public String updateGame(Game gameReq) {

        Game existingGame = this.gameRepository.findById(gameReq.getId()).orElseThrow(
                () -> new GameException("El juego con el ID especificado no existe", HttpStatus.NOT_FOUND)
        );


        existingGame.setGameName(gameReq.getGameName());





        this.gameRepository.save(existingGame);

        return "Juego actualizado correctamente.";
    }



}
