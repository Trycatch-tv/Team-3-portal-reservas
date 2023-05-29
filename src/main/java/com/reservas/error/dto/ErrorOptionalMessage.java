package com.reservas.error.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class ErrorOptionalMessage {
    private HttpStatus httpStatus;
    private String message;
}
