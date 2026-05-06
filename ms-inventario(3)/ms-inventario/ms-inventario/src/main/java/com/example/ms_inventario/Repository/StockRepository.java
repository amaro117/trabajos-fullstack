package com.example.ms_inventario.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ms_inventario.Model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    // Interfaz pura. Spring hace el resto.
    // Método extra para buscar el stock de un producto específico:
    Optional<Stock> findByProductoId(Long productoId);
}
