



package com.haryharsono.movieservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haryharsono.movieservice.dto.GenreRs;
import com.haryharsono.movieservice.service.GenreService;
import java.util.List;
/**
 * GenreImpl
 */
@Service
public class GenreImpl {
    @Autowired
    private GenreService genreService;


    public List<GenreRs> listGenre(){
        return genreService.listOfGenre().getBody();
         

    }
    
}
