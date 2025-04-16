package com.avilatek.ecommerceapi.service.user;

import com.avilatek.ecommerceapi.dto.UserDto;
import com.avilatek.ecommerceapi.model.Role;
import com.avilatek.ecommerceapi.model.User;
import com.avilatek.ecommerceapi.repository.RoleRepository;
import com.avilatek.ecommerceapi.repository.UserRepository;
import com.avilatek.ecommerceapi.request.CreateUserRequest;
import com.avilatek.ecommerceapi.request.UpdateUserRequest;
import com.avilatek.ecommerceapi.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    //    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public User createUser(CreateUserRequest request) {
        Role userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Default role USER not found"));

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setActive(true); // asegúrate que no sea null
        user.setCreatedAt(LocalDateTime.now()); // si no es default en DB
        user.setRoles(Set.of(userRole)); // userRole debe tener ID
        System.out.println("Asignando rol: " + userRole.getName() + " con ID: " + userRole.getId());


        return userRepository.save(user);
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
