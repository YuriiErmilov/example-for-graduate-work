package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.skypro.homework.exception.AccessDeniedException;

import javax.persistence.EntityNotFoundException;

/**
 * Глобальный обработчик ошибок REST API.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Возвращает 404, если сущность не найдена.
     *
     * @param exception исключение
     * @return сообщение об ошибке
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNotFound(
            EntityNotFoundException exception
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    /**
     * Возвращает 403 при отсутствии прав.
     *
     * @param exception исключение
     * @return сообщение об ошибке
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDenied(
            AccessDeniedException exception
    ) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(exception.getMessage());
    }
}
