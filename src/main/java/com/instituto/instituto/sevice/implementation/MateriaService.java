package com.instituto.instituto.sevice.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.instituto.instituto.dto.EstudianteDTO;
import com.instituto.instituto.dto.MateriaDTO;
import com.instituto.instituto.entity.Estudiante;
import com.instituto.instituto.entity.Materia;
import com.instituto.instituto.repository.IEstudianteRepository;
import com.instituto.instituto.repository.IMateriaRepository;
import com.instituto.instituto.sevice.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class MateriaService implements IMateriaService {

    @Autowired
    private IMateriaRepository materiaRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public MateriaDTO crearMateria(MateriaDTO materiaDto) {
        Materia materia = mapper.convertValue(materiaDto, Materia.class);
        Materia materiaGuardada = materiaRepository.save(materia);
        return mapper.convertValue(materiaGuardada, MateriaDTO.class);
    }

    @Override
    public MateriaDTO leerMateria(Long id) {
        Optional<Materia> materia = materiaRepository.findById(id);
        MateriaDTO materiaDto = null;
        if(materia.isPresent()){
            materiaDto = mapper.convertValue(materia, MateriaDTO.class);
        }
        return materiaDto;
    }

    @Override
    public void modificarMateria(MateriaDTO materiaDto) {
        Materia materia = mapper.convertValue(materiaDto, Materia.class);
        materiaRepository.save(materia);
        //sirve el metodo save para el put porque hibernate al darse cuenta de que
        //el objeto es enviado con id lo encuentra y lo modifica en vez de crearlo
    }

    @Override
    public void eliminarMateria(Long id) {
        materiaRepository.deleteById(id);
    }

    @Override
    public Set<MateriaDTO> getTodos() {
        List<Materia> materias = materiaRepository.findAll();
        Set<MateriaDTO> materiasDto = new HashSet<>();

        for (Materia materia: materias){
            materiasDto.add(mapper.convertValue(materia, MateriaDTO.class));
        }
        return materiasDto;
    }
}
