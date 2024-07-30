package com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CouponRequest {

    @FutureOrPresent(message = "date is not valid")
    private LocalDate expiredDate;
    @NotNull(message = "status is required")
    private Boolean status;
    @NotBlank(message = "Coupons discount is required")
    private Double discount;

}
