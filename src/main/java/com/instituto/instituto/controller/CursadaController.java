package com.instituto.instituto.controller;

import com.instituto.instituto.dto.CursadaDTO;
import com.instituto.instituto.sevice.ICursadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cursadas")
public class CursadaController {

    @Autowired
    ICursadaService cursadaService;

    @PostMapping("/add")
    public ResponseEntity<CursadaDTO> agregarCursada(@RequestBody CursadaDTO cursadaDTO) {
        ResponseEntity<CursadaDTO> response;
        CursadaDTO cursadaGuardada = cursadaService.crearCursada(cursadaDTO);
        if (cursadaGuardada != null) {
            response = ResponseEntity.ok(cursadaGuardada);
        } else {
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursadaDTO> buscarCursadaPorId(Long id) {
        ResponseEntity<CursadaDTO> response;
        CursadaDTO cursadaDTO = cursadaService.leerCursada(id);
        if (cursadaDTO != null) {
            response = ResponseEntity.ok(cursadaDTO);
        } else {
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

    @PutMapping("/agregar")
    public ResponseEntity<CursadaDTO> actualizarCursada(@RequestBody CursadaDTO cursadaDTO){
        //ResponseEntity<HttpStatus> response;
        cursadaService.modificarCursada(cursadaDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CursadaDTO> borrarCursada(Long id){
        cursadaService.eliminarCursada(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/all")
    public ResponseEntity<Set<CursadaDTO>> buscarTodos(){
        ResponseEntity<Set<CursadaDTO>> response;
        Set<CursadaDTO> cursadas = cursadaService.getTodos();
        if(cursadas != null){
            response = ResponseEntity.ok(cursadas);
        }else{
            response = ResponseEntity.notFound().build();
        }
        return response;
    }
}
