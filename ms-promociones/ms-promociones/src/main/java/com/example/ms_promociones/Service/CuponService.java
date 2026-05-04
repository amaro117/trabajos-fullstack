package com.example.ms_promociones.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_promociones.Model.Cupon;
import com.example.ms_promociones.Repository.CuponRepository;

@Service
public class CuponService {

    @Autowired
    private CuponRepository cuponRepository;

    public List<Cupon> listarTodos() {
        return cuponRepository.findAll();
    }

    public Optional<Cupon> obtenerPorId(Long id) {
        return cuponRepository.findById(id);
    }

    public Cupon obtenerPorCodigo(String codigo) {
        return cuponRepository.findByCodigo(codigo).orElse(null);
    }

    public Cupon guardar(Cupon cupon) {
        return cuponRepository.save(cupon);
    }

    public void eliminar(Long id) {
        cuponRepository.deleteById(id);
    }
}