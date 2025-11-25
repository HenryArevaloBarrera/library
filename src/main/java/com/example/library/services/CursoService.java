package com.example.library.services;

import com.example.library.model.Curso;
import com.example.library.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> findById(String identificacion) {
        return cursoRepository.findById(identificacion);
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void deleteById(String identificacion) {
        cursoRepository.deleteById(identificacion);
    }

    public List<Curso> findByNombreContaining(String nombre) {
        return cursoRepository.findByNombreContaining(nombre);
    }

    public List<Curso> findByPrograma(String programa) {
        return cursoRepository.findByPrograma(programa);
    }

    public List<Curso> findBySemestre(Integer semestre) {
        return cursoRepository.findBySemestre(semestre);
    }
}
