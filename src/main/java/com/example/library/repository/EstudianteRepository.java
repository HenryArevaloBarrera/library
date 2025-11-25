package com.example.library.repository;

import com.example.library.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, String> {

    @Query("SELECT e FROM Estudiante e WHERE e.nombre LIKE CONCAT('%',:nombre,'%')")
    List<Estudiante> findByNombreContaining(String nombre);

    List<Estudiante> findByProgramaAcademico(String programaAcademico);

    List<Estudiante> findBySemestre(Integer semestre);
}
