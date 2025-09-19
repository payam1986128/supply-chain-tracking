package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RefreshTokenRequest {
    @NotBlank
    private String refreshToken;
}
