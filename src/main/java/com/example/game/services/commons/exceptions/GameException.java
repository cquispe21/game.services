package com.example.game.services.commons.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class GameException extends RuntimeException {
private HttpStatus httpStatus;
public GameException(String message, HttpStatus httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
}
}
