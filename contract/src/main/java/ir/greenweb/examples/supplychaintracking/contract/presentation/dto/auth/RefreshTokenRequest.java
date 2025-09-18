package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RefreshTokenRequest {
    private String refreshToken;
}
