package com.challenge.foro_alura.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "curso")
@Getter @Setter
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idCurso;
    private String nombreCurso;
    private String categoriaCurso;

    @OneToMany(mappedBy = "cursoTopico", cascade = CascadeType.ALL)
    private List<TopicoEntity> topicos;

}
