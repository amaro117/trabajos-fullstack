package duoc.uc.EduCore.controller;
import duoc.uc.EduCore.model.InscripcionesModel;
import duoc.uc.EduCore.service.InscripcionesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionesController {

    @Autowired
    private InscripcionesService service;

    // 1. Registrar nuevos elementos (POST)
    @PostMapping
    public ResponseEntity<InscripcionesModel> registrar(@Valid @RequestBody InscripcionesModel inscripcion) {
        InscripcionesModel nuevaInscripcion = service.registrarInscripcion(inscripcion);
        return new ResponseEntity<>(nuevaInscripcion, HttpStatus.CREATED); // Código 201
    }

    // 2. Consultar todos los elementos (GET)
    @GetMapping
    public ResponseEntity<List<InscripcionesModel>> obtenerTodas() {
        return new ResponseEntity<>(service.obtenerTodas(), HttpStatus.OK); // Código 200
    }

    // 3. Consultar un elemento por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<InscripcionesModel> obtenerPorId(@PathVariable Long id) {
        Optional<InscripcionesModel> inscripcion = service.obtenerPorId(id);
        return inscripcion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Manejo de error 404 si no existe
    }

    // 4. Modificar información (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<InscripcionesModel> actualizar(@PathVariable Long id, @Valid @RequestBody InscripcionesModel inscripcion) {
        InscripcionesModel actualizada = service.actualizarInscripcion(id, inscripcion);
        if (actualizada != null) {
            return new ResponseEntity<>(actualizada, HttpStatus.OK); // Código 200
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Manejo de error 404
        }
    }

    // 5. Eliminar registros (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = service.eliminarInscripcion(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Código 204 (Eliminado con éxito)
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Código 404 si no se encontró
        }
    }

    // 6. Búsqueda específica por estado (GET)
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<InscripcionesModel>> buscarPorEstado(@PathVariable String estado) {
        List<InscripcionesModel> resultados = service.buscarPorEstado(estado);
        if (resultados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(resultados, HttpStatus.OK);
    }
}