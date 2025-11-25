package com.example.library.controllers;

import com.example.library.model.Author;
import com.example.library.model.Song;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongController {

    @PostMapping("/{id}")
    public Author save(@PathVariable Long id, @RequestBody Song song) {

        return null;
    }
}
