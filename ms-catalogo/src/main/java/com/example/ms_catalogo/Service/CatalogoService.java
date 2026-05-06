package com.example.ms_catalogo.Service;



import com.example.ms_catalogo.Model.Categoria;
import com.example.ms_catalogo.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogoService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria guardarCategoria(Categoria categoria) {
        // Al guardar la categoría, JPA guardará los productos automáticamente por el CascadeType.ALL
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarTodo() {
        return categoriaRepository.findAll();
    }
}