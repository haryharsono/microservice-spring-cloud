

package com.haryharsono.moviemanagementservice.dto;

import com.haryharsono.moviemanagementservice.entity.Genre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MovieDto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto {

    private Long id;
    private String name;
    private String description;
    private String title;
    private String shortDescription;
    private Double rating;
    private Genre genreId;


    
}
