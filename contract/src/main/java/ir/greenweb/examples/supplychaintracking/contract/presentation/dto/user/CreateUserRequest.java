package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.user;

import ir.greenweb.examples.supplychaintracking.contract.enumeration.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private String id;

    @Size(min = 3, max = 20)
    private String username;

    @Size(min = 6, max = 20)
    private String password;

    @NotNull
    private Role role;
}
