package com.challenge.foro_alura.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "respuesta")
@Getter @Setter
public class RespuestaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idRespuesta;
    private String mensajeRespuesta;
    private String solucionRespuesta;
    private Instant fechaCreacionTopico;

    @ManyToOne
    @JoinColumn(name = "idTopico")
    private TopicoEntity topicoRespuesta;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioEntity usuarioRespuesta;
}
