package com.haryharsono.moviemanagementservice.dto.genre;

import com.haryharsono.moviemanagementservice.dto.BaseModelsRq;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/** GenreRq */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GenreRq extends BaseModelsRq {

  private String name;

  private String description;
}
