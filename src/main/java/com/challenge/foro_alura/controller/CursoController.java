package com.challenge.foro_alura.controller;

import com.challenge.foro_alura.entity.CursoEntity;
import com.challenge.foro_alura.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarCurso(@RequestBody Map<String, String> nuevoCurso) {
        return ResponseEntity.ok(this.cursoService.registrarCurso(nuevoCurso));
    }

    @GetMapping("/lista")
    public ResponseEntity<List< Map<String, String>>> listaCurso() {
        return ResponseEntity.ok(this.cursoService.listaCurso()) ;
    }
}

