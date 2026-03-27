package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
// He quitado @Service de aquí, los controladores no llevan esa anotación
public class LibroController {

    @Autowired
    private LibroService libroService;

    // 1. Listar todos: GET http://localhost:8080/api/v1/libros
    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.getLibros();
    }

    // 2. Agregar: POST http://localhost:8080/api/v1/libros
    // ¡CORREGIDO!: Para agregar usamos @RequestBody, no @PathVariable
    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro) {
        return libroService.saveLibro(libro); // Asegúrate de que en tu Service se llame así o cámbialo
    }

    // 3. Buscar uno: GET http://localhost:8080/api/v1/libros/1
    @GetMapping("/{id}")
    public Libro buscarLibro(@PathVariable int id){
        return libroService.getLibroId(id);
    }

    // 4. Actualizar: PUT http://localhost:8080/api/v1/libros/1
    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro) {
        // Es buena práctica asegurarse de que el libro tenga el ID de la URL
        libro.setId(id);
        return libroService.updateLibro(libro);
    }

    // 5. Eliminar: DELETE http://localhost:8080/api/v1/libros/1
    @DeleteMapping("/{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.deleteLibro(id);
    }
}
