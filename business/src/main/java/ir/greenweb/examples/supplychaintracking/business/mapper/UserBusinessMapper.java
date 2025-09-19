package ir.greenweb.examples.supplychaintracking.business.mapper;

import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.UserDto;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.user.CreateUserRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.user.UserDetailsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserBusinessMapper {
    UserDto toUserDto(CreateUserRequest createUserRequest);
    UserDetailsDto toUserDetailsDto(UserDto userDto);
}
