

package com.haryharsono.moviemanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haryharsono.moviemanagementservice.dto.genre.GenreDto;
import com.haryharsono.moviemanagementservice.dto.genre.GenreRq;
import com.haryharsono.moviemanagementservice.service.impl.GenreServiceImpl;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * GenreController
 */
@RestController
@RequestMapping("/genres")
// @Validated
@Slf4j
public class GenreController {

    private final GenreServiceImpl genreServiceImpl;


    @Autowired
    public GenreController(GenreServiceImpl genreServiceImpl) {
        this.genreServiceImpl = genreServiceImpl;
    }

    @GetMapping("/genre")
    public List<GenreDto> listGenre(){
        return genreServiceImpl.MovieList();
    }
    @GetMapping("/genre/{id}")
    public GenreDto detailsGenre(@Valid @PathVariable(value = "id",required = true) Long id){
        return genreServiceImpl.detailsGenre(id);
    }
    @PatchMapping("/genre/{id}")
    public void updategenre(@Valid @PathVariable(value = "id",required = true)Long id, @RequestBody GenreRq createMovieRq){
        genreServiceImpl.updatedGenre(id,createMovieRq);
    }

    @PostMapping("/genre")
    public void saveGenre( @RequestBody GenreRq genreRq){

        log.info("controller ->{}",genreRq);
        genreServiceImpl.saveGenre(genreRq);
    }

    @DeleteMapping("/genre/{id}")
    public void deletedGenre(@Valid @PathVariable(value = "id",required = true)Long id){
        genreServiceImpl.deletedGenre(id);
    }
    
}
