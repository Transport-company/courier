package com.training.courier.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Weight
     */
    @Column(name = "weight", nullable = false)
    private Float weight;

    /**
     * Length
     */
    @Column(name = "length", nullable = false)
    private Float length;

    /**
     * Width
     */
    @Column(name = "width", nullable = false)
    private Float width;

    /**
     * Height
     */
    @Column(name = "height", nullable = false)
    private Float height;

    /**
     * Registration time
     */
    @CreationTimestamp
    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    /**
     * Update time
     */
    @UpdateTimestamp
    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;
}