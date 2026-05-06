package com.example.ms_inventario.Controller;

import com.example.ms_inventario.Dto.StockDTO;
import com.example.ms_inventario.Model.Stock;
import com.example.ms_inventario.Service.StockService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // Esto habilita los logs automáticos (requiere Lombok)
@RestController
@RequestMapping("/api/inventario")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public ResponseEntity<List<Stock>> listar() {
        log.info("Obteniendo lista de todo el stock");
        return ResponseEntity.ok(stockService.listarTodo());
    }

    @PostMapping
    public ResponseEntity<Stock> crear(@Valid @RequestBody StockDTO stockDTO) {
        log.info("Intentando crear stock para el producto ID: {}", stockDTO.getProductoId());
        
        // Transformamos el DTO a la Entidad real
        Stock nuevoStock = new Stock();
        nuevoStock.setProductoId(stockDTO.getProductoId());
        nuevoStock.setKilos(stockDTO.getKilos());

        Stock guardado = stockService.guardar(nuevoStock);
        log.info("Stock creado exitosamente con ID: {}", guardado.getId());
        
        return new ResponseEntity<>(guardado, HttpStatus.CREATED);
    }
}