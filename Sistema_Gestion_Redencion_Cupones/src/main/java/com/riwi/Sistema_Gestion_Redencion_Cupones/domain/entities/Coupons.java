package com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="cupoun")
@AllArgsConstructor
@NoArgsConstructor
public class Coupons {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private LocalDate expired_date;
    @Column(length = 100, nullable = false)
    private Boolean status;
    @Column(length = 100, nullable = false)
    private Double discount; 
}
