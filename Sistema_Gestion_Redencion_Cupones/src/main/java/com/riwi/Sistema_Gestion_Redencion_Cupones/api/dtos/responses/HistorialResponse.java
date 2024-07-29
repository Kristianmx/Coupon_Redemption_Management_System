package com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses;


import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Coupons;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Product;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class HistorialResponse {
    private Long id;
    private LocalDateTime redemptionDate;
    private UserResponse user;
    private ProductResponse product;
    private CouponResponse coupons ;
}
