package com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities;


import jakarta.persistence.*;
import lombok.*;


@Entity(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private Double price;
}
