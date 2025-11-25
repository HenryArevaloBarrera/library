package com.example.library.repository;

import com.example.library.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String> {

    @Query("SELECT c FROM Curso c WHERE c.nombre LIKE CONCAT('%',:nombre,'%')")
    List<Curso> findByNombreContaining(String nombre);

    List<Curso> findByPrograma(String programa);

    List<Curso> findBySemestre(Integer semestre);
}
