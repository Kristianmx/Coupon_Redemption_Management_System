package com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories;

import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Long> {
}
