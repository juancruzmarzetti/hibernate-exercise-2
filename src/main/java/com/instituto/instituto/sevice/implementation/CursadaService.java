package com.instituto.instituto.sevice.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.instituto.instituto.dto.CursadaDTO;
import com.instituto.instituto.dto.EstudianteDTO;
import com.instituto.instituto.entity.Cursada;
import com.instituto.instituto.entity.Estudiante;
import com.instituto.instituto.repository.ICursadaRepository;
import com.instituto.instituto.repository.IEstudianteRepository;
import com.instituto.instituto.sevice.ICursadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class CursadaService implements ICursadaService {

    @Autowired
    private ICursadaRepository cursadaRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public CursadaDTO crearCursada(CursadaDTO cursadaDto) {
        Cursada cursada = mapper.convertValue(cursadaDto, Cursada.class);
        Cursada cursadaGuardada = cursadaRepository.save(cursada);
        return mapper.convertValue(cursadaGuardada, CursadaDTO.class);
    }

    @Override
    public CursadaDTO leerCursada(Long id) {
        Optional<Cursada> cursada = cursadaRepository.findById(id);
        CursadaDTO cursadaDto = null;
        if(cursada.isPresent()){
            cursadaDto = mapper.convertValue(cursada, CursadaDTO.class);
        }
        return cursadaDto;
    }

    @Override
    public void modificarCursada(CursadaDTO cursadaDto) {
        Cursada cursada = mapper.convertValue(cursadaDto, Cursada.class);
        cursadaRepository.save(cursada);
        //sirve el metodo save para el put porque hibernate al darse cuenta de que
        //el objeto es enviado con id lo encuentra y lo modifica en vez de crearlo
    }

    @Override
    public void eliminarCursada(Long id) {
        cursadaRepository.deleteById(id);
    }

    @Override
    public Set<CursadaDTO> getTodos() {
        List<Cursada> cursadas = cursadaRepository.findAll();
        Set<CursadaDTO> cursadasDto = new HashSet<>();

        for (Cursada cursada: cursadas){
            cursadasDto.add(mapper.convertValue(cursada, CursadaDTO.class));
        }
        return cursadasDto;
    }
}
