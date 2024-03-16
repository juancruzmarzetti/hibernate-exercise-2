package com.instituto.instituto.sevice;

import com.instituto.instituto.dto.CursadaDTO;
import com.instituto.instituto.dto.EstudianteDTO;

import java.util.Set;

public interface ICursadaService {

    CursadaDTO crearCursada(CursadaDTO cursadaDto);
    CursadaDTO leerCursada(Long id);
    void modificarCursada(CursadaDTO cursadaDto);
    void eliminarCursada(Long id);
    Set<CursadaDTO> getTodos();
}
