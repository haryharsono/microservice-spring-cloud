

package com.haryharsono.moviemanagementservice.dto.genre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GenreDto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreDto {

    private Long id;

    private String name;

    private String description;


}
