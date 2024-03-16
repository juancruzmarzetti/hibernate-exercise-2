package com.instituto.instituto.controller;


import com.instituto.instituto.dto.MateriaDTO;
import com.instituto.instituto.sevice.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    IMateriaService materiaService;

    @PostMapping("/add")
    public ResponseEntity<MateriaDTO> agregarMateria(@RequestBody MateriaDTO materiaDTO) {
        ResponseEntity<MateriaDTO> response;
        MateriaDTO materiaGuardada = materiaService.crearMateria(materiaDTO);
        if (materiaGuardada != null) {
            response = ResponseEntity.ok(materiaGuardada);
        } else {
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> buscarMateriaPorId(Long id) {
        ResponseEntity<MateriaDTO> response;
        MateriaDTO materiaDto = materiaService.leerMateria(id);
        if (materiaDto != null) {
            response = ResponseEntity.ok(materiaDto);
        } else {
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

    @PutMapping("/agregar")
    public ResponseEntity<HttpStatus> actualizarMateria(@RequestBody MateriaDTO materiaDTO){
        //ResponseEntity<HttpStatus> response;
        materiaService.modificarMateria(materiaDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> borrarMateria(Long id){
        materiaService.eliminarMateria(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/all")
    public ResponseEntity<Set<MateriaDTO>> buscarTodos(){
        ResponseEntity<Set<MateriaDTO>> response;
        Set<MateriaDTO> materias = materiaService.getTodos();
        if(materias != null){
            response = ResponseEntity.ok(materias);
        }else{
            response = ResponseEntity.notFound().build();
        }
        return response;
    }
}
