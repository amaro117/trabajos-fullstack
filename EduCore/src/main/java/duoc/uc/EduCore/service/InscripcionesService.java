package duoc.uc.EduCore.service;
import duoc.uc.EduCore.model.InscripcionesModel;
import duoc.uc.EduCore.repository.InscripcionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionesService {

    @Autowired
    private InscripcionesRepository repository;

    // Registrar nuevo elemento
    public InscripcionesModel registrarInscripcion(InscripcionesModel inscripcion) {
        return repository.guardar(inscripcion);
    }

    // Consultar todos
    public List<InscripcionesModel> obtenerTodas() {
        return repository.obtenerTodas();
    }

    // Consultar por ID
    public Optional<InscripcionesModel> obtenerPorId(Long id) {
        return repository.obtenerPorId(id);
    }

    // Modificar registro
    public InscripcionesModel actualizarInscripcion(Long id, InscripcionesModel inscripcionActualizada) {
        // Verificamos si existe antes de actualizar para evitar errores
        Optional<InscripcionesModel> existente = repository.obtenerPorId(id);
        if (existente.isPresent()) {
            inscripcionActualizada.setId(id); // Aseguramos que mantenga el mismo ID
            return repository.actualizar(inscripcionActualizada);
        }
        return null; // Retornamos null si no existe para que el Controller maneje el error 404
    }

    // Eliminar registro
    public boolean eliminarInscripcion(Long id) {
        return repository.eliminar(id);
    }

    // Búsqueda específica
    public List<InscripcionesModel> buscarPorEstado(String estado) {
        return repository.buscarPorEstado(estado);
    }
}