
package com.haryharsono.moviemanagementservice.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haryharsono.moviemanagementservice.Repository.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haryharsono.moviemanagementservice.Exception.NotFoundException;
import com.haryharsono.moviemanagementservice.Repository.GenreRepository;
import com.haryharsono.moviemanagementservice.dto.MovieDto;
import com.haryharsono.moviemanagementservice.dto.MovieRq;
import com.haryharsono.moviemanagementservice.entity.Genre;
import com.haryharsono.moviemanagementservice.entity.Movie;
import com.haryharsono.moviemanagementservice.service.MovieService;

/**
 * MovieServiceImpl
 */
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository GenreRepository;
    private final ObjectMapper objectMapper;


    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository,GenreRepository genreRepository,ObjectMapper objectMapper) {
        this.movieRepository = movieRepository;
        GenreRepository = genreRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void saveMovie(MovieRq movieRq) {
        // TODO Auto-generated method stub
        Genre genre=GenreRepository.findById(movieRq.getGenreId().longValue()).orElseThrow(() -> new NotFoundException("Id Genre Not Found"));
        movieRepository.save(Movie
                .builder()
                .name(movieRq.getName())
                .title(movieRq.getTitle())
                .description(movieRq.getDescription())
                .shortDescription(movieRq.getShortDescription())
                .image(movieRq.getImage())
                .createdDate(movieRq.getCreatedDate())
                .createdBy(movieRq.getCreatedBy())
                .genreId(genre)
                .build());
    }

    @Override
    public void updatedMovie(Long id,MovieRq movieRq) {
        // TODO Auto-generated method stub
        Movie movie=movieRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Movie Not Found"));
        Genre genre=GenreRepository.findById(movieRq.getGenreId().longValue()).orElseThrow(() -> new NotFoundException("Id Genre Not Found"));
        movie.setName(movieRq.getName());
        movie.setTitle(movieRq.getTitle());
        movie.setDescription(movieRq.getDescription());
        movie.setShortDescription(movieRq.getShortDescription());
        movie.setImage(movieRq.getImage());
        movie.setUpdatedBy(movieRq.getUpdatedBy());
        movie.setUpdatedDate(movieRq.getCreatedDate());
        movie.setGenreId(genre);
        movieRepository.saveAndFlush(movie);
    }

    @Override
    public void deletedMovie(Long id) {
        // TODO Auto-generated method stub
        Movie movie=movieRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Movie Not Found"));
        movie.setIsDeleted(Boolean.TRUE);
        movie.setUpdatedDate(new Date());
        movie.setUpdatedBy("SYSTEM");
    }

    @Override
    public MovieDto detailsMovie(Long id) {
        // TODO Auto-generated method stub
        Movie movie=movieRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
        return objectMapper.convertValue(movie, MovieDto.class);
    }

    @Override
    public List<MovieDto> listMovie() {
        // TODO Auto-generated method stub
        return movieRepository.findAll().stream().map(x -> (
                    objectMapper.convertValue(x, MovieDto.class)
                    )).toList();

    }


    
}
