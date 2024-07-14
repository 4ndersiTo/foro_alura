package com.challenge.foro_alura.controller;

import com.challenge.foro_alura.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    // INFO ->  Se movio para AuthController
//    @PostMapping("/registrar")
//    public ResponseEntity<String> registrarUsuario(@RequestBody Map<String, String> nuevoUsuario) {
//        return ResponseEntity.ok(this.usuarioService.registrarUsuario(nuevoUsuario));
//    }

}
