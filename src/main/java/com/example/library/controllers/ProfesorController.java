package com.example.library.controllers;

import com.example.library.model.Docente;
import com.example.library.repository.DocenteRepository;
import com.example.library.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/docentes")
public class ProfesorController {

    @Autowired
    DocenteRepository docenteRepository;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            List<Docente> docentes = docenteRepository.findAll();
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, docentes);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{identificacion}")
    public ResponseEntity<Object> findOne(@PathVariable String identificacion) {
        try {
            Optional<Docente> docente = docenteRepository.findById(identificacion);
            if (docente.isPresent()) {
                return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, docente.get());
            } else {
                return ResponseHandler.generateResponse("Docente not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Docente docente) {
        try {
            Docente savedDocente = docenteRepository.save(docente);
            return ResponseHandler.generateResponse("Docente created successfully", HttpStatus.CREATED, savedDocente);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PutMapping("/{identificacion}")
    public ResponseEntity<Object> update(@PathVariable String identificacion, @RequestBody Docente docente) {
        try {
            Optional<Docente> existingDocente = docenteRepository.findById(identificacion);
            if (existingDocente.isPresent()) {
                docente.setIdentificacion(identificacion);
                Docente updatedDocente = docenteRepository.save(docente);
                return ResponseHandler.generateResponse("Docente updated successfully", HttpStatus.OK, updatedDocente);
            } else {
                return ResponseHandler.generateResponse("Docente not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{identificacion}")
    public ResponseEntity<Object> delete(@PathVariable String identificacion) {
        try {
            Optional<Docente> docente = docenteRepository.findById(identificacion);
            if (docente.isPresent()) {
                docenteRepository.deleteById(identificacion);
                return ResponseHandler.generateResponse("Docente deleted successfully", HttpStatus.OK, null);
            } else {
                return ResponseHandler.generateResponse("Docente not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/like/{nombre}")
    public ResponseEntity<Object> findByNombre(@PathVariable String nombre) {
        try {
            List<Docente> docentes = docenteRepository.findByNombreContaining(nombre);
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, docentes);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/departamento/{departamento}")
    public ResponseEntity<Object> findByDepartamento(@PathVariable String departamento) {
        try {
            List<Docente> docentes = docenteRepository.findByDepartamento(departamento);
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, docentes);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
