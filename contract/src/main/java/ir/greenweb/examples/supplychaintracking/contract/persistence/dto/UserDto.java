package ir.greenweb.examples.supplychaintracking.contract.persistence.dto;

import ir.greenweb.examples.supplychaintracking.contract.enumeration.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String id;
    private String username;
    private String password;
    private Role role;
}
