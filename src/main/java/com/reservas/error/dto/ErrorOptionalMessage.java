package com.reservas.error.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter @Getter @ToString
@AllArgsConstructor @NoArgsConstructor
public class ErrorOptionalMessage {
    private HttpStatus httpStatus;
    private String message;
}
