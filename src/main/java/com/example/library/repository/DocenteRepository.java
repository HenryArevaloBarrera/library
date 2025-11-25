package com.example.library.repository;

import com.example.library.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, String> {

    @Query("SELECT d FROM Docente d WHERE d.nombre LIKE CONCAT('%',:nombre,'%')")
    List<Docente> findByNombreContaining(String nombre);

    List<Docente> findByDepartamento(String departamento);
}
