package com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CouponResponse {
    
    private Long id;
    private LocalDate expired_date;
    private Boolean status;
    private Double discount;

    
}
