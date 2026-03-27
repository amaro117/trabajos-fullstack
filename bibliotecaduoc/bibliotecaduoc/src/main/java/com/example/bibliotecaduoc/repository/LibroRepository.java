package com.example.bibliotecaduoc.repository;
import com.example.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Repository
public class LibroRepository {

    private  List<Libro> listaLibros =  new ArrayList<>();


    public List<Libro> obtenerLibros(){
        return listaLibros;
    }

    public Libro bsucarPorId(int id){
        for (Libro libro : listaLibros){
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }
    public Libro buscar(String isbn) {
        for (Libro libro : listaLibros){
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
    public Libro guardar(Libro lib) {
        listaLibros.add(lib);
        return lib;
    }
    public Libro Actualizar(Libro lib) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {
            if  (listaLibros.get(i).getId() ==  lib.getId()){
                id = lib.getId();
                idPosicion = i;
            }
        }
        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(libro1.getIsbn());

        listaLibros.set(idPosicion, libro1);
        return libro1;
    }
    public void  eliminar (int id) {
        Libro libro  = bsucarPorId(id);
        if (libro != null){
            listaLibros.remove(libro);
        }
        int idPosicion = 0;
        for  ( int i = 0; i< listaLibros.size(); i++){
            if (listaLibros.get(i).getId() == id) {
                idPosicion = i;
                break;
            }
            if (idPosicion > 0) {
                listaLibros.remove(idPosicion);
            }
            listaLibros.removeIf(x -> x.getId() == id);
        }
    }
}
