package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.UserRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.UserResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.User;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories.UserRepository;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services.IUserService;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.mappers.UserMapper;
import com.riwi.Sistema_Gestion_Redencion_Cupones.utils.exceptions.BadRequestException;
import com.riwi.Sistema_Gestion_Redencion_Cupones.utils.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Override
    public UserResponse create(UserRequest request) {
        this.verifyUserInfo(request.getEmail(), request.getUserName());

        User user = userMapper.toEntity(request);
        User createdUser = userRepository.save(user);
        return userMapper.toResponse(createdUser);
    }

    @Override
    public UserResponse get(Long id) {
        User user = findUser(id);
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse update(Long id, UserRequest request) {
        this.verifyUserInfo(request.getEmail(), request.getUserName());
        User user = findUser(id);
        User userToUpdate = this.userMapper.toEntity(request);
        userToUpdate.setId(user.getId());

        return this.userMapper.toResponse(this.userRepository.save(userToUpdate));
    }

    @Override
    public void delete(Long id) {
        User user = findUser(id);
        userRepository.delete(user);
    }

    @Override
    public User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IdNotFoundException("USER"));
    }

    private BadRequestException verifyUserInfo(String email, String username) {
        if (this.userRepository.findByUserName(username) != null) {
            throw  new BadRequestException ("This username is already taken");
        }
        if (this.userRepository.findByEmail(email) != null) {
            throw new BadRequestException("This email is already taken");
        }
        return null;
    }
}
