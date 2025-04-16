package com.avilatek.ecommerceapi.service.user;

import com.avilatek.ecommerceapi.dto.UserDto;
import com.avilatek.ecommerceapi.model.User;
import com.avilatek.ecommerceapi.repository.UserRepository;
import com.avilatek.ecommerceapi.request.CreateUserRequest;
import com.avilatek.ecommerceapi.request.UpdateUserRequest;
import com.avilatek.ecommerceapi.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    //    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public User createUser(CreateUserRequest request) {
        return Optional.of(request)
                .filter(user -> !userRepository.existsByEmail(request.getEmail()))
                .map(req -> {
                    User user = new User();
                    user.setEmail(request.getEmail());
                    user.setPassword(passwordEncoder.encode(request.getPassword()));
                    user.setFirstName(request.getFirstName());
                    user.setLastName(request.getLastName());
                    return userRepository.save(user);
                }).orElseThrow(() -> new RuntimeException(request.getEmail() + " already exists!"));
    }

    @Override
    public User updateUser(UpdateUserRequest request, Long userId) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public UserDto convertUserToDto(User user) {
        return null;
    }

    @Override
    public User getAuthenticatedUser() {
        return null;
    }
}
