package com.challenge.foro_alura.service;

import com.challenge.foro_alura.entity.CursoEntity;

import java.util.List;
import java.util.Map;

public interface CursoService {
    String registrarCurso(Map<String, String> nuevoCurso);

    List<Map<String, String>>  listaCurso();

    CursoEntity cursoPorId(String idCurso);
}
