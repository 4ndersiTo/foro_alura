package com.challenge.foro_alura.repository;

import com.challenge.foro_alura.entity.CursoEntity;
import com.challenge.foro_alura.entity.TopicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<TopicoEntity, String> {
}
