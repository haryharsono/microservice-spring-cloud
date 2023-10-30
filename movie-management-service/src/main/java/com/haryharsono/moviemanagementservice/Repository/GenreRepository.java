
package com.haryharsono.moviemanagementservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haryharsono.moviemanagementservice.entity.Genre;

/**
 * GenreRepository
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {


    
}
