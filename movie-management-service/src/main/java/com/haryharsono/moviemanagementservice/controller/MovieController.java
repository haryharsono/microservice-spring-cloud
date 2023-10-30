

package com.haryharsono.moviemanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haryharsono.moviemanagementservice.dto.MovieDto;
import com.haryharsono.moviemanagementservice.dto.MovieRq;
import com.haryharsono.moviemanagementservice.service.impl.MovieServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

import java.util.List;

/**
 * MovieController
 */
@RestController
@RequestMapping("/movie")
@Validated
public class MovieController {
    private final MovieServiceImpl movieServiceImpl;




    @Autowired
    public MovieController(MovieServiceImpl movieServiceImpl) {
        this.movieServiceImpl = movieServiceImpl;
    }
    @GetMapping("/movie")
    public List<MovieDto> listMovie(){
        return movieServiceImpl.listMovie();
    }
    @GetMapping("/movie/{id}")
    public MovieDto detailsMovie(@Valid @PathVariable(value = "id",required = true) Long id){
        return movieServiceImpl.detailsMovie(id);
    }
    @PatchMapping("/movie/{id}")
    public void updateMovie(@Valid @PathVariable(value = "id",required = true)Long id, @RequestBody MovieRq createMovieRq){
        movieServiceImpl.updatedMovie(id,createMovieRq);
    }

    @PostMapping("/movie")
    public void saveGenre(@Valid @RequestBody MovieRq movieRq){
        movieServiceImpl.saveMovie(movieRq);
    }

    @DeleteMapping("/movie/{id}")
    public void deletedGenre(@Valid @PathVariable(value = "id",required = true)Long id){
        movieServiceImpl.deletedMovie(id);
    }
 

    
}
