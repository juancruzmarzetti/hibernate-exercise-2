package com.instituto.instituto.sevice.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.instituto.instituto.dto.EstudianteDTO;
import com.instituto.instituto.entity.Estudiante;
import com.instituto.instituto.repository.IEstudianteRepository;
import com.instituto.instituto.sevice.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class EstudianteService implements IEstudianteService {
    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDto) {
        Estudiante estudiante = mapper.convertValue(estudianteDto, Estudiante.class);
        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);
        return mapper.convertValue(estudianteGuardado, EstudianteDTO.class);
    }

    @Override
    public EstudianteDTO leerEstudiante(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        EstudianteDTO estudianteDTO = null;
        if(estudiante.isPresent()){
            estudianteDTO = mapper.convertValue(estudiante, EstudianteDTO.class);
        }
        return estudianteDTO;
    }

    @Override
    public void modificarEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = mapper.convertValue(estudianteDTO, Estudiante.class);
        estudianteRepository.save(estudiante);
        //sirve el metodo save para el put porque hibernate al darse cuenta de que
        //el objeto es enviado con id lo encuentra y lo modifica en vez de crearlo
    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public Set<EstudianteDTO> getTodos() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        Set<EstudianteDTO> estudiantesDto = new HashSet<>();

        for (Estudiante estudiante: estudiantes){
            estudiantesDto.add(mapper.convertValue(estudiante, EstudianteDTO.class));
        }
        return estudiantesDto;
    }
}
