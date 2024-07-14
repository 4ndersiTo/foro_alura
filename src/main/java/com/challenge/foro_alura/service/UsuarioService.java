package com.challenge.foro_alura.service;

import com.challenge.foro_alura.entity.UsuarioEntity;

import java.util.Map;

public interface UsuarioService {
    String registrarUsuario(Map<String, String> nuevoUsuario) ;

    UsuarioEntity usuarioPorId(String idUsuario);

    UsuarioEntity usuarioPorEmail(String correo);
}
