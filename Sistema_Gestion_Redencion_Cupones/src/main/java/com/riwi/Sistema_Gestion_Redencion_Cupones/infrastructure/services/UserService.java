package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.UserRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.UserResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories.UserRepository;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services.IUserService;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.mappers.UserMapper;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public UserResponse get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public UserResponse update(Long id, UserRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
