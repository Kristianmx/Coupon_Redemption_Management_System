package com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private Double price;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<History> histories;
}
