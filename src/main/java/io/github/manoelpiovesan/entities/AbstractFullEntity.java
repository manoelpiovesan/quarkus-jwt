package io.github.manoelpiovesan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

/**
 * @author Manoel Rodrigues
 */
@MappedSuperclass
abstract class AbstractFullEntity extends AbstractEntity {

    @JsonIgnore
    @Column(
            name = "created_at",
            nullable = false,
            updatable = false,
            columnDefinition = "timestamp with time zone not null"
    )
    public Date createdAt = new Date();

    @JsonIgnore
    @Column(
            name = "updated_at",
            nullable = false,
            columnDefinition = "timestamp with time zone not null"
    )
    public Date updatedAt = new Date();

    @JsonIgnore
    @Column(
            name = "deleted_at",
            nullable = false,
            columnDefinition = "timestamp with time zone"
    )
    public Date deletedAt = new Date(0);

}