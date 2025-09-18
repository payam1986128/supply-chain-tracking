package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthResponse {
    private String accessToken;
    private String refreshToken;
}
