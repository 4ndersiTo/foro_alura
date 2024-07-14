package com.challenge.foro_alura.service.impl;

import com.challenge.foro_alura.entity.UsuarioEntity;
import com.challenge.foro_alura.security.jwt.JwtService;
import com.challenge.foro_alura.service.AuthService;
import com.challenge.foro_alura.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Map<String, String> login(Map<String, String> credenciales) {
        try {
            //info: Valida usuario y contraseña
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credenciales.get("email"), credenciales.get("password")));
        } catch (AuthenticationException badCredentialsException) {
            if (badCredentialsException instanceof BadCredentialsException) {
                throw new BadCredentialsException("Usuario o contraseña ingresadas son inválidos.");
            }
        }

        UsuarioEntity user = this.usuarioService.usuarioPorEmail(credenciales.get("email"));
        String token = this.jwtService.getToken(user);

        // info: RETORNA el TOKEN
        return Map.of("token", token);
    }

    @Override
    public String register(Map<String,String> nuevoUsuario) {
        return this.usuarioService.registrarUsuario(nuevoUsuario);
    }
}
