package com.example.ms_promociones.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms_promociones.Model.Cupon;
import com.example.ms_promociones.Service.CuponService;

@RestController
@RequestMapping("/api/promociones")
public class CuponController {

    @Autowired
    private CuponService cuponService;

    @GetMapping
    public List<Cupon> listar() {
        return cuponService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cupon> obtener(@PathVariable Long id) {
        return cuponService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para que el carrito valide si el cupón existe: /api/promociones/validar/ECO10
    @GetMapping("/validar/{codigo}")
    public ResponseEntity<Cupon> validarCupon(@PathVariable String codigo) {
        Cupon cupon = cuponService.obtenerPorCodigo(codigo);
        return cupon != null ? ResponseEntity.ok(cupon) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Cupon crear(@RequestBody Cupon cupon) {
        return cuponService.guardar(cupon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cuponService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}