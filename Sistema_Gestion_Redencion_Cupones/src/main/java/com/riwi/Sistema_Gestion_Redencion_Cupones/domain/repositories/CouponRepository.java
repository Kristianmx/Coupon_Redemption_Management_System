package com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    
}
