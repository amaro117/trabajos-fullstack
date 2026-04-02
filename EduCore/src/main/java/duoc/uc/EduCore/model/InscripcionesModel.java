package duoc.uc.EduCore.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

import java.time.LocalDate;

public class InscripcionesModel {
    private Long id;
    @NotBlank(message = "El rut o nombre del estudiante no puede estar vacio")
    private String rutEstudiante;

    @NotBlank(message = "El nombre del curso es obligatorio")
    private String nombreCurso;

    @NotBlank(message = "El estado ej.Activo. Finalizando es obligatorio")
    private String estado;

    @NotNull(message = "La fecha de inscripcion es obligatoria")
    private LocalDate fechaInscripcion;

    public InscripcionesModel() {
    }

    public InscripcionesModel(Long id, String rutEstudiante, String nombreCurso, String estado, LocalDate fechaInscripcion) {
        this.id = id;
        this.rutEstudiante = rutEstudiante;
        this.nombreCurso = nombreCurso;
        this.estado = estado;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRutEstudiante() {
        return rutEstudiante;
    }

    public void setRutEstudiante(String rutEstudiante) {
        this.rutEstudiante = rutEstudiante;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}