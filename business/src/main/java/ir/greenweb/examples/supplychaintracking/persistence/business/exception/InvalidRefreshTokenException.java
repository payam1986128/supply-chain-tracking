package ir.greenweb.examples.supplychaintracking.persistence.business.exception;

import org.springframework.security.core.AuthenticationException;

public class InvalidRefreshTokenException extends AuthenticationException {

    public InvalidRefreshTokenException() {
        super("Invalid refresh token");
    }
}
