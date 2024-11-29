package com.sparta.currency_user.exception;

import com.sparta.currency_user.dto.ErrorResponseDto;
import com.sparta.currency_user.dto.StatusResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StatusResponseDto> handleIllegalArgumentExceptionNotFound(
            IllegalArgumentException exception
    ) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                "NOT_FOUND",
                exception.getMessage(),
                exception.getLocalizedMessage(),
                LocalDateTime.now()
        );

        StatusResponseDto statusResponse = new StatusResponseDto("error", 404, errorResponse);

        return new ResponseEntity<>(statusResponse, HttpStatus.NOT_FOUND);
    }
}
