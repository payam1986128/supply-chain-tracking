package ir.greenweb.examples.supplychaintracking.business.service;

import ir.greenweb.examples.supplychaintracking.business.exception.InvalidRefreshTokenException;
import ir.greenweb.examples.supplychaintracking.business.exception.UserAlreadyExistsException;
import ir.greenweb.examples.supplychaintracking.business.exception.UserNotFoundException;
import ir.greenweb.examples.supplychaintracking.contract.business.UserServiceApi;
import ir.greenweb.examples.supplychaintracking.contract.persistence.UserDaoApi;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.UserDto;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth.AuthRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth.AuthResponse;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.auth.RefreshTokenResponse;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.user.CreateUserRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.user.UserDetailsDto;
import ir.greenweb.examples.supplychaintracking.business.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserServiceApi {

    private final UserDaoApi userDao;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return userMapper.toUserDetailsDto(userDto);
    }

    private UserDetailsDto getUserDetails(String username) {
        UserDto userDto = userDao.findByUsername(username)
                .orElseThrow(UserNotFoundException::new);
        return userMapper.toUserDetailsDto(userDto);
    }

    @Override
    public void createUser(CreateUserRequest user) {
        if (userDao.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(userMapper.toUserDto(user));
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsDto user = getUserDetails(request.getUsername());

        String accessToken = jwtTokenService.generateAccessToken(user);
        String refreshToken = jwtTokenService.generateRefreshToken(user);

        return new AuthResponse(accessToken, refreshToken);
    }

    @Override
    public RefreshTokenResponse refreshToken(String refreshToken) {
        String username = jwtTokenService.getUsernameFromToken(refreshToken);
        UserDetailsDto user = getUserDetails(username);

        if (!jwtTokenService.isValidRefreshToken(refreshToken, user.getUsername())) {
            throw new InvalidRefreshTokenException();
        }

        String newAccessToken = jwtTokenService.generateAccessToken(user);
        return new RefreshTokenResponse(newAccessToken);
    }
}
