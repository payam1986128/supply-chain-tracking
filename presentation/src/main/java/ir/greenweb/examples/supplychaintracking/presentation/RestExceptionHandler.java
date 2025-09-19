package ir.greenweb.examples.supplychaintracking.presentation;

import ir.greenweb.examples.supplychaintracking.business.exception.EntityNotFoundException;
import ir.greenweb.examples.supplychaintracking.business.exception.HandledException;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.exception.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public ExceptionDto handleException(AuthenticationException ex) {
        return new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ExceptionDto handleException(AccessDeniedException ex) {
        return new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ExceptionDto handleException(EntityNotFoundException ex) {
        return new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HandledException.class)
    public ExceptionDto handleException(HandledException ex) {
        return new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionDto handleException(Exception ex) {
        return new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage());
    }
}
