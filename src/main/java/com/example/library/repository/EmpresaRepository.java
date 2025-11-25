package com.example.library.repository;

import com.example.library.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query("SELECT e FROM Empresa e WHERE e.nombre LIKE CONCAT('%',:nombre,'%')")
    List<Empresa> findByNombreContaining(String nombre);

    List<Empresa> findBySector(String sector);

    List<Empresa> findByCiudad(String ciudad);
}
