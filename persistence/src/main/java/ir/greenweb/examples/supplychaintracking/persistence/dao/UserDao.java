package ir.greenweb.examples.supplychaintracking.persistence.dao;

import ir.greenweb.examples.supplychaintracking.contract.persistence.UserDaoApi;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.UserDto;
import ir.greenweb.examples.supplychaintracking.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserDao implements UserDaoApi {

    private final UserRepository userRepository;

    @Override
    public Optional<UserDto> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public void save(UserDto user) {

    }
}
