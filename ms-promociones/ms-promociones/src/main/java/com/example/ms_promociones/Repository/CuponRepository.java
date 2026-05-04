package com.example.ms_promociones.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ms_promociones.Model.Cupon;
@Repository
    public interface CuponRepository extends JpaRepository<Cupon, Long> {
    
    // Spring Boot implementará la búsqueda por el campo "codigo" automáticamente
    Optional<Cupon> findByCodigo(String codigo);


}
