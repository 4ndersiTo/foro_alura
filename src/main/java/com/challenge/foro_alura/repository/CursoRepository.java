package com.challenge.foro_alura.repository;

import com.challenge.foro_alura.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, String> {
}
