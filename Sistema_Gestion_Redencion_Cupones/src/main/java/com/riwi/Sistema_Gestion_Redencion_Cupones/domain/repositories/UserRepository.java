package com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUserName(String userName);

  User findByEmail(String email);
}
