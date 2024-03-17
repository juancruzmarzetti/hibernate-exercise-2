package com.instituto.instituto.dto;

import com.instituto.instituto.entity.Estudiante;
import com.instituto.instituto.entity.Materia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursadaDTO {

    private Long id;
    private Estudiante estudiante;
    private Materia materia;
    private double nota;
}
