package com.challenge.foro_alura.service.impl;

import com.challenge.foro_alura.entity.CursoEntity;
import com.challenge.foro_alura.repository.CursoRepository;
import com.challenge.foro_alura.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public String registrarCurso(Map<String, String> nuevoCurso) {

        CursoEntity newCurso = new CursoEntity();

        newCurso.setNombreCurso(nuevoCurso.get("nombre"));
        newCurso.setCategoriaCurso(nuevoCurso.get("categoria"));
        cursoRepository.save(newCurso);

        return "Se registró el curso con éxito.";
    }

    @Override
    public List<Map<String, String>> listaCurso() {

        // info -> si se quiere un orden para mostrar los campos en el JSON se debe crear un DTO
        return this.cursoRepository.findAll().stream().map(curso ->
                Map.of(
                        "id", curso.getIdCurso(),
                        "nombre", curso.getNombreCurso(),
                        "categoria", curso.getCategoriaCurso()
                )
        ).toList();
    }

    @Override
    public CursoEntity cursoPorId(String idCurso) {
        return this.cursoRepository.findById(idCurso).orElseThrow(() -> new RuntimeException("No se encontró un curso con id " + idCurso));
    }
}
