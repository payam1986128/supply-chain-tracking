package ir.greenweb.examples.supplychaintracking.contract.persistence;

import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.UserDto;

import java.util.Optional;

public interface UserDaoApi {
    Optional<UserDto> findByUsername(String username);
    void save(UserDto user);
}
