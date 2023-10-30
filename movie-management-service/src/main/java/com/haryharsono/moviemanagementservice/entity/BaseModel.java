

package com.haryharsono.moviemanagementservice.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * BaseModel
 */
@SuperBuilder
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseModel {
    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedDate
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;


    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "is_deleted")
    @Builder.Default
    private Boolean isDeleted=Boolean.FALSE;
    
}
