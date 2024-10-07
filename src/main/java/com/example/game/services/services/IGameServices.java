package com.example.game.services.services;

import com.example.game.services.commons.entities.Game;

public interface IGameServices {
    Game saveGame (Game gameReq);
    Game getGameById (Long gameId);

    String deleteGame (Long gameId);
    String updateGame (Game gameReq);

}
