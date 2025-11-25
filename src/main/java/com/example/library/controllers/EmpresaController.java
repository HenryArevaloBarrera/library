package com.example.library.controllers;

import com.example.library.model.Empresa;
import com.example.library.repository.EmpresaRepository;
import com.example.library.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    
    @Autowired
    EmpresaRepository empresaRepository;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            List<Empresa> empresas = empresaRepository.findAll();
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, empresas);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable Long id) {
        try {
            Optional<Empresa> empresa = empresaRepository.findById(id);
            if (empresa.isPresent()) {
                return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, empresa.get());
            } else {
                return ResponseHandler.generateResponse("Empresa not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Empresa empresa) {
        try {
            Empresa savedEmpresa = empresaRepository.save(empresa);
            return ResponseHandler.generateResponse("Empresa created successfully", HttpStatus.CREATED, savedEmpresa);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Empresa empresa) {
        try {
            Optional<Empresa> existingEmpresa = empresaRepository.findById(id);
            if (existingEmpresa.isPresent()) {
                empresa.setId(id);
                Empresa updatedEmpresa = empresaRepository.save(empresa);
                return ResponseHandler.generateResponse("Empresa updated successfully", HttpStatus.OK, updatedEmpresa);
            } else {
                return ResponseHandler.generateResponse("Empresa not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            Optional<Empresa> empresa = empresaRepository.findById(id);
            if (empresa.isPresent()) {
                empresaRepository.deleteById(id);
                return ResponseHandler.generateResponse("Empresa deleted successfully", HttpStatus.OK, null);
            } else {
                return ResponseHandler.generateResponse("Empresa not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/like/{nombre}")
    public ResponseEntity<Object> findByNombre(@PathVariable String nombre) {
        try {
            List<Empresa> empresas = empresaRepository.findByNombreContaining(nombre);
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, empresas);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/sector/{sector}")
    public ResponseEntity<Object> findBySector(@PathVariable String sector) {
        try {
            List<Empresa> empresas = empresaRepository.findBySector(sector);
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, empresas);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<Object> findByCiudad(@PathVariable String ciudad) {
        try {
            List<Empresa> empresas = empresaRepository.findByCiudad(ciudad);
            return ResponseHandler.generateResponse("Success OK!!", HttpStatus.OK, empresas);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
