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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private AuthServiceApi authService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse createUser(@Valid @RequestBody CreateUserRequest request) {
        return authService.createUser(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse login(@Valid @RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }

    @PostMapping("/refresh-token")
    @ResponseStatus(HttpStatus.OK)
    public RefreshTokenResponse refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest.getRefreshToken());
    }
}
