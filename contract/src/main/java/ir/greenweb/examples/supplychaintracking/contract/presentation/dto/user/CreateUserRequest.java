package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.user;

import ir.greenweb.examples.supplychaintracking.contract.enumeration.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private String id;
    private String username;
    private String password;
    private Role role;
}
