package ir.greenweb.examples.supplychaintracking.contract.business;

import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth.AuthRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth.AuthResponse;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth.RefreshTokenResponse;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.user.CreateUserRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.user.CreateUserResponse;

public interface AuthServiceApi {
    CreateUserResponse createUser(CreateUserRequest user);
    AuthResponse login(AuthRequest request);
    RefreshTokenResponse refreshToken(String refreshToken);
}
