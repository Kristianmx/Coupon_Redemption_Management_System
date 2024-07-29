package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.CouponRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.CouponResponse;

public interface ICouponService extends GenericService<CouponRequest, CouponResponse, Long> {
    
}
