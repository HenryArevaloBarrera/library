package com.example.library.controllers;

import com.example.library.model.Curso;
import com.example.library.repository.CursoRepository;
import com.example.library.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            List<Curso> cursos = cursoRepository.findAll();
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, cursos);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{identificacion}")
    public ResponseEntity<Object> findOne(@PathVariable String identificacion) {
        try {
            Optional<Curso> curso = cursoRepository.findById(identificacion);
            if (curso.isPresent()) {
                return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, curso.get());
            } else {
                return ResponseHandler.generateResponse("Curso not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Curso curso) {
        try {
            Curso savedCurso = cursoRepository.save(curso);
            return ResponseHandler.generateResponse("Curso created successfully", HttpStatus.CREATED, savedCurso);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PutMapping("/{identificacion}")
    public ResponseEntity<Object> update(@PathVariable String identificacion, @RequestBody Curso curso) {
        try {
            Optional<Curso> existingCurso = cursoRepository.findById(identificacion);
            if (existingCurso.isPresent()) {
                curso.setIdentificacion(identificacion);
                Curso updatedCurso = cursoRepository.save(curso);
                return ResponseHandler.generateResponse("Curso updated successfully", HttpStatus.OK, updatedCurso);
            } else {
                return ResponseHandler.generateResponse("Curso not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{identificacion}")
    public ResponseEntity<Object> delete(@PathVariable String identificacion) {
        try {
            Optional<Curso> curso = cursoRepository.findById(identificacion);
            if (curso.isPresent()) {
                cursoRepository.deleteById(identificacion);
                return ResponseHandler.generateResponse("Curso deleted successfully", HttpStatus.OK, null);
            } else {
                return ResponseHandler.generateResponse("Curso not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/like/{nombre}")
    public ResponseEntity<Object> findByNombre(@PathVariable String nombre) {
        try {
            List<Curso> cursos = cursoRepository.findByNombreContaining(nombre);
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, cursos);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/programa/{programa}")
    public ResponseEntity<Object> findByPrograma(@PathVariable String programa) {
        try {
            List<Curso> cursos = cursoRepository.findByPrograma(programa);
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, cursos);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/semestre/{semestre}")
    public ResponseEntity<Object> findBySemestre(@PathVariable Integer semestre) {
        try {
            List<Curso> cursos = cursoRepository.findBySemestre(semestre);
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, cursos);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
