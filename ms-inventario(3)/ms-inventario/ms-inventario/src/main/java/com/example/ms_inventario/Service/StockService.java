package com.example.ms_inventario.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_inventario.Model.Stock;
import com.example.ms_inventario.Repository.StockRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    // Listar todo el stock de la bodega
    public List<Stock> listarTodo() {
        return stockRepository.findAll();
    }

    // Buscar el stock específico de un producto
    public Optional<Stock> obtenerPorProductoId(Long productoId) {
        return stockRepository.findByProductoId(productoId);
    }

    // Guardar o actualizar la cantidad de un producto
    public Stock guardar(Stock stock) {
        return stockRepository.save(stock);
    }

    // Eliminar un registro de stock
    public void eliminar(Long id) {
        stockRepository.deleteById(id);
    }
}
