package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.UserRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.UserResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.User;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.generics.GenericMapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserRequest, UserResponse, User> {

}
