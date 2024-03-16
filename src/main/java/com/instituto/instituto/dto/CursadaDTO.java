package com.instituto.instituto.dto;

import com.instituto.instituto.entity.Estudiante;
import com.instituto.instituto.entity.Materia;

public class CursadaDTO {

    private Long id;
    private Estudiante estudiante;
    private Materia materia;
    private double nota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
