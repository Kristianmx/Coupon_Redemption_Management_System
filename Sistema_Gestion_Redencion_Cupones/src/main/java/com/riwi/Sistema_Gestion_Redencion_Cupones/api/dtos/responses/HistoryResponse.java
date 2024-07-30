package com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoryResponse {
    private Long id;
    private LocalDateTime redemptionDate;
    private UserResponse user;
    private ProductResponse product;
    private CouponResponse coupons;
}
