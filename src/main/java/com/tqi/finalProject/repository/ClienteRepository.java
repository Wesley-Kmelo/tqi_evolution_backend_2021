package com.tqi.finalProject.repository;

import com.tqi.finalProject.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {
      @Query("select c from Cliente c where c.email = ?1")
      Cliente getByEmail(String email);
}
