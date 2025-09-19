package ir.greenweb.examples.supplychaintracking.contract.persistence;

import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.UserDto;

import java.util.Optional;
import java.util.UUID;

public interface UserDaoApi {
    Optional<UserDto> findByUsername(String username);
    UUID save(UserDto user);
}
