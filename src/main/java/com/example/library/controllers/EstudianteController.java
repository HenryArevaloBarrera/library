package com.example.library.controllers;

import com.example.library.model.Estudiante;
import com.example.library.repository.EstudianteRepository;
import com.example.library.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    EstudianteRepository estudianteRepository;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            List<Estudiante> estudiantes = estudianteRepository.findAll();
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, estudiantes);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Object> findOne(@PathVariable String codigo) {
        try {
            Optional<Estudiante> estudiante = estudianteRepository.findById(codigo);
            if (estudiante.isPresent()) {
                return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, estudiante.get());
            } else {
                return ResponseHandler.generateResponse("Estudiante not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Estudiante estudiante) {
        try {
            Estudiante savedEstudiante = estudianteRepository.save(estudiante);
            return ResponseHandler.generateResponse("Estudiante created successfully", HttpStatus.CREATED,
                    savedEstudiante);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Object> update(@PathVariable String codigo, @RequestBody Estudiante estudiante) {
        try {
            Optional<Estudiante> existingEstudiante = estudianteRepository.findById(codigo);
            if (existingEstudiante.isPresent()) {
                estudiante.setCodigo(codigo);
                Estudiante updatedEstudiante = estudianteRepository.save(estudiante);
                return ResponseHandler.generateResponse("Estudiante updated successfully", HttpStatus.OK,
                        updatedEstudiante);
            } else {
                return ResponseHandler.generateResponse("Estudiante not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Object> delete(@PathVariable String codigo) {
        try {
            Optional<Estudiante> estudiante = estudianteRepository.findById(codigo);
            if (estudiante.isPresent()) {
                estudianteRepository.deleteById(codigo);
                return ResponseHandler.generateResponse("Estudiante deleted successfully", HttpStatus.OK, null);
            } else {
                return ResponseHandler.generateResponse("Estudiante not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/like/{nombre}")
    public ResponseEntity<Object> findByNombre(@PathVariable String nombre) {
        try {
            List<Estudiante> estudiantes = estudianteRepository.findByNombreContaining(nombre);
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, estudiantes);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/programa/{programa}")
    public ResponseEntity<Object> findByPrograma(@PathVariable String programa) {
        try {
            List<Estudiante> estudiantes = estudianteRepository.findByProgramaAcademico(programa);
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, estudiantes);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/semestre/{semestre}")
    public ResponseEntity<Object> findBySemestre(@PathVariable Integer semestre) {
        try {
            List<Estudiante> estudiantes = estudianteRepository.findBySemestre(semestre);
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, estudiantes);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
