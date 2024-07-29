package com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses;


import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Coupons;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Product;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistorialResponse {
    private Long id;
    private LocalDateTime redemptionDate;
    private User user;
    private Product product;
    private Coupons coupon ;
}
