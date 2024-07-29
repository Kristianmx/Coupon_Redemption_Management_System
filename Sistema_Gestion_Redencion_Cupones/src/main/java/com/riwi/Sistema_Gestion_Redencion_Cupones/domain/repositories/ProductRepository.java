package com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories;

import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
