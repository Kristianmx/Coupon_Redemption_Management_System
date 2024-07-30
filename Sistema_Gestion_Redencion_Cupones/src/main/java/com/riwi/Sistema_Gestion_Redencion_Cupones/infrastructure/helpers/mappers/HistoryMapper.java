package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.mappers;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.HistoryRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.CouponResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.HistoryResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Coupons;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.History;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.generics.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HistoryMapper extends GenericMapper<HistoryRequest, HistoryResponse, History> {

    CouponResponse couponsToResponseCoupons(Coupons coupons);
}
