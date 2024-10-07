package com.example.game.services.controller.impl;

import com.example.game.services.commons.DTOs.ErrorResponse;
import com.example.game.services.commons.exceptions.GameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerControl {


    @ExceptionHandler(value = {GameException.class})


    ResponseEntity<ErrorResponse> handleGameException(GameException ex) {


        var errorResponse = ErrorResponse.builder().codeStatus(ex.getHttpStatus().value()).message(ex.getMessage()).build();


        return ResponseEntity.status(ex.getHttpStatus()).body(errorResponse);


    }
}
