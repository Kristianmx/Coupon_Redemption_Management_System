package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.CouponRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.CouponResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Coupons;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.generics.GenericMapper;

@Mapper(componentModel = "spring")

public interface CouponMapper extends GenericMapper<CouponRequest,CouponResponse, Coupons> {
    
}
