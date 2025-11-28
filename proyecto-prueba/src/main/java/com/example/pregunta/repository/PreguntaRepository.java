package com.example.pregunta.repository;

import com.example.pregunta.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

    @Query(value = "SELECT * FROM pregunta ORDER BY RANDOM() LIMIT :count", nativeQuery = true)
    List<Pregunta> findRandomPreguntas(@Param("count") int count);
}
