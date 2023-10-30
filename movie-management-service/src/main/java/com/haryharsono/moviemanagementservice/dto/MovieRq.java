
package com.haryharsono.moviemanagementservice.dto;

import com.haryharsono.moviemanagementservice.entity.Genre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * MovieRq
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MovieRq extends BaseModelsRq{

    private String name;

    private String description;

    private String title;

    private String shortDescription;

    private Double rating;

    private Integer genreId;

    private String image;

    private String string;

    
}
