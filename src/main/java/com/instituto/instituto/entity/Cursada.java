package com.instituto.instituto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cursadas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cursada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;
    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;
    private double nota;
}
