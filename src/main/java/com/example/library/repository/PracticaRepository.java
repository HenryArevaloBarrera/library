package com.example.library.repository;

import com.example.library.model.Practica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PracticaRepository extends JpaRepository<Practica, Long> {

    @Query("SELECT p FROM Practica p WHERE p.actividad LIKE CONCAT('%',:actividad,'%')")
    List<Practica> findByActividadContaining(String actividad);

    List<Practica> findByTipoActividad(String tipoActividad);

    List<Practica> findByPeriodoAcademico(String periodoAcademico);
}
