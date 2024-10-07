package com.example.game.services.commons.DTOs;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private Integer codeStatus;
    private String message;
}
