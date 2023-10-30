
package com.haryharsono.moviemanagementservice.service;


import java.util.List;

import com.haryharsono.moviemanagementservice.dto.genre.GenreDto;
import com.haryharsono.moviemanagementservice.dto.genre.GenreRq;

/**
 * GenreService
 */
public interface GenreService {

    
    void saveGenre(GenreRq rq); 
    void updatedGenre(Long id,GenreRq rq); 
    void deletedGenre(Long id); 
    GenreDto detailsGenre(Long id);
    List<GenreDto> MovieList();

    
}
