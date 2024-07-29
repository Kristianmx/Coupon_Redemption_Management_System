package com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses;

import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Historial;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Product;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

public class ProductResponse {
    private Long id;
    private String name;
    private Double price;
    private List<Historial> products;
}
