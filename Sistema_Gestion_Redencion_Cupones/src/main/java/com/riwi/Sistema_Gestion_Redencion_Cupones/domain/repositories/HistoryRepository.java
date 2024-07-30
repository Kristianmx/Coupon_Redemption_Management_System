package com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories;

import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.History;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    public List<History> findAllByUser_Id(Long id);
}
