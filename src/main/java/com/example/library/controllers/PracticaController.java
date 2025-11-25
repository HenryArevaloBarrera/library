package com.example.library.controllers;

import com.example.library.model.Practica;
import com.example.library.repository.PracticaRepository;
import com.example.library.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/practicas")
public class PracticaController {
    
    @Autowired
    PracticaRepository practicaRepository;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            List<Practica> practicas = practicaRepository.findAll();
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, practicas);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable Long id) {
        try {
            Optional<Practica> practica = practicaRepository.findById(id);
            if (practica.isPresent()) {
                return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, practica.get());
            } else {
                return ResponseHandler.generateResponse("Practica not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Practica practica) {
        try {
            Practica savedPractica = practicaRepository.save(practica);
            return ResponseHandler.generateResponse("Practica created successfully", HttpStatus.CREATED, savedPractica);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Practica practica) {
        try {
            Optional<Practica> existingPractica = practicaRepository.findById(id);
            if (existingPractica.isPresent()) {
                practica.setId(id);
                Practica updatedPractica = practicaRepository.save(practica);
                return ResponseHandler.generateResponse("Practica updated successfully", HttpStatus.OK, updatedPractica);
            } else {
                return ResponseHandler.generateResponse("Practica not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            Optional<Practica> practica = practicaRepository.findById(id);
            if (practica.isPresent()) {
                practicaRepository.deleteById(id);
                return ResponseHandler.generateResponse("Practica deleted successfully", HttpStatus.OK, null);
            } else {
                return ResponseHandler.generateResponse("Practica not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/like/{actividad}")
    public ResponseEntity<Object> findByActividad(@PathVariable String actividad) {
        try {
            List<Practica> practicas = practicaRepository.findByActividadContaining(actividad);
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, practicas);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<Object> findByTipo(@PathVariable String tipo) {
        try {
            List<Practica> practicas = practicaRepository.findByTipoActividad(tipo);
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, practicas);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/periodo/{periodo}")
    public ResponseEntity<Object> findByPeriodo(@PathVariable String periodo) {
        try {
            List<Practica> practicas = practicaRepository.findByPeriodoAcademico(periodo);
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, practicas);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
