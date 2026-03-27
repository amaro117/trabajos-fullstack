package com.example.GameCenter.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GameCenter.model.Videojuego;
import com.example.GameCenter.service.VideojuegoService;
@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {
    @Autowired 
    private VideojuegoService service;

    
    @GetMapping
    public List<Videojuego> listar() {
        return service.listarTodos();
    }

    
    @GetMapping("/{id}")
    public Optional<Videojuego> buscar(@PathVariable int id) {
        return service.buscarPorId(id);
    }

    
    @PostMapping
    public Videojuego guardar(@RequestBody Videojuego videojuego) {
        return service.guardar(videojuego);
    }

    
    @PutMapping("/{id}")
    public Videojuego actualizar(@PathVariable int id, @RequestBody Videojuego videojuego) {
        videojuego.setId(id); 
        return service.actualizar(videojuego);
    }

    
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }
}


