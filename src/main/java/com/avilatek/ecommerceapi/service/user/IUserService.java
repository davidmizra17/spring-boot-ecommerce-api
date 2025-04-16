package com.avilatek.ecommerceapi.service.user;

import com.avilatek.ecommerceapi.dto.UserDto;
import com.avilatek.ecommerceapi.model.User;
import com.avilatek.ecommerceapi.request.CreateUserRequest;
import com.avilatek.ecommerceapi.request.UpdateUserRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UpdateUserRequest request, Long userId);
    void deleteUser(Long userId);
    UserDto convertUserToDto(User user);
    User getAuthenticatedUser();
}