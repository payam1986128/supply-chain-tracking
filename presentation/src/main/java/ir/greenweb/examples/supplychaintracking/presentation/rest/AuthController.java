package ir.greenweb.examples.supplychaintracking.presentation.rest;

import ir.greenweb.examples.supplychaintracking.contract.business.AuthServiceApi;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth.AuthRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth.AuthResponse;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth.RefreshTokenRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth.RefreshTokenResponse;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.user.CreateUserRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.user.CreateUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private AuthServiceApi authService;

    @PostMapping("/users")
    public CreateUserResponse createUser(@Valid @RequestBody CreateUserRequest request) {
        return authService.createUser(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }

    @PostMapping("/refresh-token")
    public RefreshTokenResponse refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest.getRefreshToken());
    }
}
