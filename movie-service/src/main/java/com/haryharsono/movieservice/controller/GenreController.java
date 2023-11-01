

package com.haryharsono.movieservice.controller;

import com.haryharsono.movieservice.dto.GenreRs;
import com.haryharsono.movieservice.service.GenreService;
import com.haryharsono.movieservice.service.impl.GenreImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GenreController
 */
@RestController
@RequestMapping("genres")
public class GenreController {

    private final GenreImpl genreService;


    @Autowired
    public GenreController(GenreImpl genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genre")
    public List<GenreRs> listGenre(){
        return genreService.listGenre();
    }

}
