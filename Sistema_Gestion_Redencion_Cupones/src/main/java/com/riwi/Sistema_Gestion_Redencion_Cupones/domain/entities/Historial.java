package com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "historial")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private LocalDateTime redemptionDate;
    @Column(nullable = false)
    private Boolean status;
}
