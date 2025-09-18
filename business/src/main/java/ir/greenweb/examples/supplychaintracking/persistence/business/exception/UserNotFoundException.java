package ir.greenweb.examples.supplychaintracking.persistence.business.exception;

import org.springframework.security.core.AuthenticationException;

public class UserNotFoundException extends AuthenticationException {
    public UserNotFoundException() {
        super("User not found");
    }
}
