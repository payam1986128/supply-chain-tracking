package ir.greenweb.examples.supplychaintracking.presentation.rest;

import ir.greenweb.examples.supplychaintracking.contract.business.UserServiceApi;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth.AuthRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth.AuthResponse;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth.RefreshTokenRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth.RefreshTokenResponse;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.user.CreateUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private UserServiceApi userService;

    @PostMapping("/users")
    public void createUser(@RequestBody CreateUserRequest request) {
        userService.createUser(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return userService.login(authRequest);
    }

    @PostMapping("/access-token")
    public RefreshTokenResponse getAccessToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return userService.refreshToken(refreshTokenRequest.getRefreshToken());
    }
}
