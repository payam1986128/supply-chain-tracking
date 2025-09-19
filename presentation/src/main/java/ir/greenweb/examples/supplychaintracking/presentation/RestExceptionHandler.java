package ir.greenweb.examples.supplychaintracking.presentation;

import ir.greenweb.examples.supplychaintracking.business.exception.EntityNotFoundException;
import ir.greenweb.examples.supplychaintracking.business.exception.HandledException;
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
    public void handleException(AuthenticationException ex) {

    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public void handleException(AccessDeniedException ex) {

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public void handleException(EntityNotFoundException ex) {

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HandledException.class)
    public void handleException(HandledException ex) {

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public void handleException(Exception ex) {

    }
}
