package com.challenge.foro_alura.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "topico")
@Getter
@Setter
public class TopicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idTopico;
    private String tituloTopico;
    private String mensajeTopico;
    private Instant fechaCreacionTopico = Instant.now();
    private String estadoTopico;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private CursoEntity cursoTopico;

    //info -> AUTOR (usuario)
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioEntity autorTopico;

    @OneToMany(mappedBy = "topicoRespuesta", cascade = CascadeType.ALL)
    private List<RespuestaEntity> respuestas;

}
