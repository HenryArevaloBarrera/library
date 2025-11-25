package com.example.library.controllers;

import com.example.library.dtos.AuthorDTO;
import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import com.example.library.responses.ResponseHandler;
import com.example.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try{
            List<Author> authors = authorService.findAll();

            return ResponseHandler.generateResponse("Succes OK!!", HttpStatus.OK,authors);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,null);
        }

    }

    @GetMapping("/{id}")
    public Author findOne(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public Author save(@RequestBody  Author author) {
        return authorService.save(author);
    }

    @GetMapping("/dto")
    public List<AuthorDTO> findAllAuthors() {

        return authorService.findByLastName();
    }

    @GetMapping("/like/{name}")
    public List<Author> findLike(@PathVariable String name) {

        return authorService.findLike(name);
    }
}
