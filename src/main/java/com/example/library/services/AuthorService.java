package com.example.library.services;

import com.example.library.dtos.AuthorDTO;
import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {

        return authorRepository.findAll();
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public List<AuthorDTO> findByLastName() {

        return authorRepository.findAllAuthors();
    }

    public List<Author> findLike(String name) {

        return authorRepository.getLike(name);
    }
}
