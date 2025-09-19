package ir.greenweb.examples.supplychaintracking.business.service;

import ir.greenweb.examples.supplychaintracking.business.mapper.UserBusinessMapper;
import ir.greenweb.examples.supplychaintracking.contract.persistence.UserDaoApi;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserDaoApi userDao;
    private final UserBusinessMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return userMapper.toUserDetailsDto(userDto);
    }
}
