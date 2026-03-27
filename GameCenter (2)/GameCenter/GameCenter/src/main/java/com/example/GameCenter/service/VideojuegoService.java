package com.example.GameCenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GameCenter.model.Videojuego;
import com.example.GameCenter.repository.VideojuegoRepository;
@Service
public class VideojuegoService {
@Autowired 
    private VideojuegoRepository repository;

    public List<Videojuego> listarTodos() {
        return repository.findAll(); 
    }

    public Optional<Videojuego> buscarPorId(int id) {
        return repository.findById(id); 
    }

    public Videojuego guardar(Videojuego videojuego) {
        return repository.save(videojuego);
    }

    public Videojuego actualizar(Videojuego videojuego) {
        return repository.update(videojuego); 
    }

    public void eliminar(int id) {
        repository.delete(id); 
    }
}

