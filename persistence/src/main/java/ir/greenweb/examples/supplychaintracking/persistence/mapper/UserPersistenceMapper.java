package ir.greenweb.examples.supplychaintracking.persistence.mapper;

import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.UserDto;
import ir.greenweb.examples.supplychaintracking.persistence.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {
    UserDto toUserDto(User user);
    User toUser(UserDto userDto);
}
