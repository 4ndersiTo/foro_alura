package com.challenge.foro_alura.service.impl;

import com.challenge.foro_alura.entity.UsuarioEntity;
import com.challenge.foro_alura.repository.UsuarioRepository;
import com.challenge.foro_alura.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String registrarUsuario(Map<String, String> nuevoUsuario) {

        UsuarioEntity newUsuario = new UsuarioEntity();
        newUsuario.setNombreUsuario(nuevoUsuario.get("nombre"));
        newUsuario.setEmailUsuario(nuevoUsuario.get("email"));
        newUsuario.setPasswordUsuario(this.passwordEncoder.encode(nuevoUsuario.get("password"))); // INFO: ENCRIPTACION DE PASSWORD

        this.usuarioRepository.save(newUsuario);

        return "Se registró el usuario con éxito";
    }

    @Override
    public UsuarioEntity usuarioPorId(String idUsuario) {
        return this.usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("No se encontró un usuario con el ID: " + idUsuario));
    }

    @Override
    public UsuarioEntity usuarioPorEmail(String correo) {
        return this.usuarioRepository.findByEmailUsuario(correo).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }
}
