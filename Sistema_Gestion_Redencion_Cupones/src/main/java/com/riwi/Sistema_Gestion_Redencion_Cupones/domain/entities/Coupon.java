package com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name="coupons")
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private LocalDate expired_date;
    @Column(length = 100, nullable = false)
    private Boolean status;
    @Column(length = 100, nullable = false)
    private Double discount;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "coupons",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Coupon> coupons;
}
