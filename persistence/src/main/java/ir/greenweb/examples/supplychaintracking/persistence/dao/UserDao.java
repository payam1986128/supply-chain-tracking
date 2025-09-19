package ir.greenweb.examples.supplychaintracking.persistence.dao;

import ir.greenweb.examples.supplychaintracking.contract.persistence.UserDaoApi;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.UserDto;
import ir.greenweb.examples.supplychaintracking.persistence.entity.User;
import ir.greenweb.examples.supplychaintracking.persistence.mapper.UserPersistenceMapper;
import ir.greenweb.examples.supplychaintracking.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserDao implements UserDaoApi {

    private final UserRepository userRepository;
    private final UserPersistenceMapper userMapper;

    @Override
    public Optional<UserDto> findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.map(userMapper::toUserDto);
    }

    @Override
    public UUID save(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        userRepository.save(user);
        return user.getId();
    }
}
