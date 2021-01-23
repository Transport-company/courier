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
 * Address entity
 */
@Entity
@Table(name = "address")
@Data
public class Address {

    /**
     * Unique identifier
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    /**
     * Country region
     */
    @Column(name = "region", nullable = false)
    private String region;

    /**
     * City
     */
    @Column(name = "city", nullable = false)
    private String city;

    /**
     * Street
     */
    @Column(name = "street")
    private String street;

    /**
     * House number
     */
    @Column(name = "house", nullable = false)
    private String house;

    /**
     * Apartment number
     */
    @Column(name = "apartment")
    private String apartment;

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