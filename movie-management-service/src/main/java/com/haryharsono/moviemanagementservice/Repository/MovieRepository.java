


package com.haryharsono.moviemanagementservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haryharsono.moviemanagementservice.entity.Movie;

/**
 * MovieRepository
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long > {

    
}
