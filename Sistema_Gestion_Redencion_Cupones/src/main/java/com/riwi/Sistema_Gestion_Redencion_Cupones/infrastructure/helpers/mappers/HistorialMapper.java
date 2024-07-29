package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.mappers;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.HistorialRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.CouponResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.HistorialResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.ProductResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.UserResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Coupons;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Historial;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Product;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.User;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.generics.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HistorialMapper extends GenericMapper<HistorialRequest, HistorialResponse, Historial> {

//    UserResponse toResponseUser(User user);
    CouponResponse couponsToResponseCoupons(Coupons coupons);
//
//    ProductResponse toResponseProduct(Product product);
}
