package duoc.uc.EduCore.repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import duoc.uc.EduCore.model.InscripcionesModel;
import org.springframework.stereotype.Repository;

@Repository
public class InscripcionesRepository {
    private final List<InscripcionesModel> inscripcionesModel = new ArrayList<>();
    private Long generadorId = 1L;

    // 1. Registrar nuevos elementos [cite: 13, 43]
    public InscripcionesModel guardar(InscripcionesModel inscripcion) {
        inscripcion.setId(generadorId++);
        inscripcionesModel.add(inscripcion);
        return inscripcion;
    }

    // 2. Consultar todos los elementos almacenados [cite: 14, 44]
    public List<InscripcionesModel> obtenerTodas() {
        // Retornamos una nueva lista para no exponer la referencia original en memoria
        return new ArrayList<>(inscripcionesModel);
    }

    // 3. Consultar un elemento específico por su ID [cite: 14]
    public Optional<InscripcionesModel> obtenerPorId(Long id) {
        return inscripcionesModel.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }

    // 4. Modificar información de registros existentes [cite: 15, 46]
    public InscripcionesModel actualizar(InscripcionesModel inscripcionActualizada) {
        for (int i = 0; i < inscripcionesModel.size(); i++) {
            if (inscripcionesModel.get(i).getId().equals(inscripcionActualizada.getId())) {
                inscripcionesModel.set(i, inscripcionActualizada);
                return inscripcionActualizada;
            }
        }
        return null; // Si retorna null, el Service deberá manejar el error de recurso inexistente [cite: 69, 70, 72]
    }

    // 5. Eliminar registros del sistema [cite: 16, 47]
    public boolean eliminar(Long id) {
        return inscripcionesModel.removeIf(i -> i.getId().equals(id));
    }

    // 6. Búsqueda específica / Operación de procesamiento [cite: 17, 45, 48, 51]
    // Nota: Asumo que tu InscripcionesModel tiene un método getEstado().
    // Si usaste otro atributo como nombreCurso o nivel, solo cambia el "getEstado()" por tu getter correspondiente.
    public List<InscripcionesModel> buscarPorEstado(String estado) {
        return inscripcionesModel.stream()
                .filter(i -> i.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }
}