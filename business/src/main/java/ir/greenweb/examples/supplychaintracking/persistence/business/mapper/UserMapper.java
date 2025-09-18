package ir.greenweb.examples.supplychaintracking.persistence.business.mapper;

import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.UserDto;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.user.CreateUserRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.user.UserDetailsDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto toUserDto(CreateUserRequest createUserRequest);
    UserDetailsDto toUserDetailsDto(UserDto userDto);
}
