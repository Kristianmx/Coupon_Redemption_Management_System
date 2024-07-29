package com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistorialRequest {
    @NotNull(message = "User ID cannot be null")
    @Positive(message = "User ID must be a positive value")
    private Long userId;
    @NotNull(message = "Cupon ID cannot be null")
    @Positive(message = "Cupon ID must be a positive value")
    private Long cuponId;
    @NotNull(message = "Product ID cannot be null")
    @Positive(message = "Product ID must be a positive value")
    private Long productsId;
}
