package com.instituto.instituto.sevice;

import com.instituto.instituto.dto.EstudianteDTO;

import java.util.Set;

public interface IEstudianteService {
    EstudianteDTO crearEstudiante(EstudianteDTO estudianteDto);
    EstudianteDTO leerEstudiante(Long id);
    void modificarEstudiante(EstudianteDTO estudianteDTO);
    void eliminarEstudiante(Long id);
    Set<EstudianteDTO> getTodos();
}
