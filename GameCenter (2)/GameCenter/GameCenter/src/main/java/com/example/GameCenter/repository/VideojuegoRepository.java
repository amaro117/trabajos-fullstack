package com.example.GameCenter.repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.GameCenter.model.Videojuego;
@Repository
public class VideojuegoRepository {

    private List<Videojuego> videojuegos = new ArrayList<>();

    public List<Videojuego> findAll() {
        return videojuegos;
    }

    public Optional<Videojuego> findById(int id) {
        return videojuegos.stream().filter(v -> v.getId() == id).findFirst();
    }

    public Videojuego save(Videojuego videojuego) {
        videojuegos.add(videojuego);
        return videojuego;
    }

    public Videojuego update(Videojuego videojuego) {
        for (int i = 0; i < videojuegos.size(); i++) {
            if (videojuegos.get(i).getId() == videojuego.getId()) {
                videojuegos.set(i, videojuego);
                return videojuego;
            }
        }
        return null;
    }

    public void delete(int id) {
        videojuegos.removeIf(v -> v.getId() == id);
    }
}

