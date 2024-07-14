package com.challenge.foro_alura.controller;

import com.challenge.foro_alura.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> credenciales) {
        return ResponseEntity.ok(this.authService.login(credenciales));
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> nuevoUsuario) {
        return ResponseEntity.ok(this.authService.register(nuevoUsuario));
    }
}
