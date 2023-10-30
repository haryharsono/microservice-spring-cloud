

package com.haryharsono.moviemanagementservice.service;
import java.util.List;
import com.haryharsono.moviemanagementservice.dto.*;

/**
 * MovieService
 */
public interface MovieService {

    
    void saveMovie(MovieRq movieRq); 
    void updatedMovie(Long id,MovieRq movieRq); 
    void deletedMovie(Long id); 
    MovieDto detailsMovie(Long id);
    List<MovieDto> listMovie();
    
}
