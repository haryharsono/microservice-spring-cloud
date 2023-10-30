


package com.haryharsono.moviemanagementservice.dto;

import java.sql.Date;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * BaseModelsRq
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseModelsRq {


    private Date createdDate;

    private Date updatedDate;

    private String createdBy;

    private String updatedBy;


}
