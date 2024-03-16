package com.instituto.instituto.sevice;

import com.instituto.instituto.dto.EstudianteDTO;
import com.instituto.instituto.dto.MateriaDTO;

import java.util.Set;

public interface IMateriaService{

    MateriaDTO crearMateria(MateriaDTO materiaDto);
    MateriaDTO leerMateria(Long id);
    void modificarMateria(MateriaDTO materiaDto);
    void eliminarMateria(Long id);
    Set<MateriaDTO> getTodos();
}
