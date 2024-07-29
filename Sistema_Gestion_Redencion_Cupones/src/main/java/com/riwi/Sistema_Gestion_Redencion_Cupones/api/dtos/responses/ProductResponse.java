package com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses;

import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Historial;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private Double price;
}
