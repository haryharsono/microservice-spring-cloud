



package com.haryharsono.moviemanagementservice.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haryharsono.moviemanagementservice.Exception.NotFoundException;
import com.haryharsono.moviemanagementservice.Repository.GenreRepository;
import com.haryharsono.moviemanagementservice.dto.genre.GenreDto;
import com.haryharsono.moviemanagementservice.dto.genre.GenreRq;
import com.haryharsono.moviemanagementservice.entity.Genre;
import com.haryharsono.moviemanagementservice.service.GenreService;

import lombok.extern.slf4j.Slf4j;

/**
 * GenreServiceImpl
 */

@Service
@Slf4j
public class GenreServiceImpl implements GenreService{

    private final GenreRepository genreRepository;

    private final ObjectMapper objectMapper;


    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository, ObjectMapper objectMapper) {
        this.genreRepository = genreRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void saveGenre(GenreRq rq) {
        // TODO Auto-generated method stub
        log.info("rq ->{}",rq);
        genreRepository.saveAndFlush(objectMapper.convertValue(rq, Genre.class));
    }

    @Override
    public void updatedGenre(Long id,GenreRq rq) {
        // TODO Auto-generated method stub
        Genre genre=genreRepository.findById(id).orElseThrow(() ->new NotFoundException("Id Not Found"));
        genre.setName(rq.getName());
        genre.setDescription(rq.getDescription());
        genre.setUpdatedBy(rq.getUpdatedBy());
        genre.setUpdatedDate(rq.getUpdatedDate());
        genreRepository.saveAndFlush(genre);
    }

    @Override
    public void deletedGenre(Long id) {
        // TODO Auto-generated method stub
        Genre genre=genreRepository.findById(id).orElseThrow(() ->new NotFoundException("Id Not Found"));
        genre.setUpdatedDate(new Date());
        genre.setUpdatedBy("SYSTEM");
        genre.setIsDeleted(Boolean.TRUE);
        genreRepository.saveAndFlush(genre);
    }

    @Override
    public GenreDto detailsGenre(Long id) {
        // TODO Auto-generated method stub
        Genre genre=genreRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
        return objectMapper.convertValue(genre, GenreDto.class);
    }

    @Override
    public List<GenreDto> MovieList() {
        // TODO Auto-generated method stub
        return genreRepository.findAll().stream().map(x -> (
                    objectMapper.convertValue(x, GenreDto.class)
                    )).toList();
    }
     

    
}
