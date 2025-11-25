package com.example.library.repository;

import com.example.library.dtos.AuthorDTO;
import com.example.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT new com.example.library.dtos.AuthorDTO(lastName,firstName) FROM Author")
    List<AuthorDTO> findAllAuthors();

    @Query("SELECT a FROM Author a WHERE a.lastName LIKE CONCAT('%',:name,'%')")
    public List<Author> getLike(String name);
}
