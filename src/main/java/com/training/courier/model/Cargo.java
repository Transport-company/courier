package com.training.courier.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Cargo entity
 */
@Entity
@Table(name = "cargo")
@Data
public class Cargo {

    /**
     * Unique identifier
     */
    @Column(name = "id")
    private Long id;

    /**
     * Weight
     */
    @Column(name = "weight")
    private Float weight;

    /**
     * Length
     */
    @Column(name = "length")
    private Float length;

    /**
     * Width
     */
    @Column(name = "width")
    private Float width;

    /**
     * Height
     */
    @Column(name = "height")
    private Float height;

    /**
     * Registration time
     */
    @CreationTimestamp
    @Column(name = "created")
    private LocalDateTime created;

    /**
     * Update time
     */
    @UpdateTimestamp
    @Column(name = "updated")
    private LocalDateTime updated;
}