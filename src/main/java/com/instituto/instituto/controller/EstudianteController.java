package com.instituto.instituto.controller;

import com.instituto.instituto.dto.EstudianteDTO;
import com.instituto.instituto.sevice.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    IEstudianteService estudianteService;

    @PostMapping("/add")
    public ResponseEntity<EstudianteDTO> agregarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        ResponseEntity<EstudianteDTO> response;
        EstudianteDTO estudianteGuardado = estudianteService.crearEstudiante(estudianteDTO);
        if (estudianteGuardado != null) {
            response = ResponseEntity.ok(estudianteGuardado);
        } else {
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> buscarEstudiantePorId(Long id) {
        ResponseEntity<EstudianteDTO> response;
        EstudianteDTO estudianteDto = estudianteService.leerEstudiante(id);
        if (estudianteDto != null) {
            response = ResponseEntity.ok(estudianteDto);
        } else {
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

    @PutMapping("/agregar")
    public ResponseEntity<HttpStatus> actualizarEstudiante(@RequestBody EstudianteDTO estudianteDto){
        //ResponseEntity<HttpStatus> response;
        estudianteService.modificarEstudiante(estudianteDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> borrarEstudiante(Long id){
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/all")
    public ResponseEntity<Set<EstudianteDTO>> buscarTodos(){
        ResponseEntity<Set<EstudianteDTO>> response;
        Set<EstudianteDTO> estudiantes = estudianteService.getTodos();
        if(estudiantes != null){
            response = ResponseEntity.ok(estudiantes);
        }else{
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

}