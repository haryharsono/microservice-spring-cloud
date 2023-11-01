package com.haryharsono.movieservice.service;

import com.haryharsono.movieservice.dto.GenreRs;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/** MovieService */

@FeignClient(name = "movie-management-service", url = "http://localhost:8080")
public interface GenreService {

  @GetMapping("/genres/genre")
  public ResponseEntity<List<GenreRs>> listOfGenre();
}
