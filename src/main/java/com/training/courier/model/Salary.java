package com.training.courier.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Courier salary entity
 */
@Entity
@Table(name = "salary")
@Data
public class Salary {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Courier information
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "courier_id", referencedColumnName = "id", nullable = false)
    private Courier courier;

    /**
     *  Date
     */
    @Column(name = "date", nullable = false)
    private LocalDate date;

    /**
     * Base rate per one delivery
     */
    @Column(name = "base_rate", nullable = false)
    private BigDecimal baseRate;

    /**
     * Coefficient depending on cargo weight
     */
    @Column(name = "weight_factor", nullable = false)
    private BigDecimal weightFactor;

    /**
     * Coefficient depending on cargo volume
     */
    @Column(name = "volume_factor", nullable = false)
    private BigDecimal volumeFactor;

    /**
     * Coefficient depending on delivery distance
     */
    @Column(name = "distance_factor", nullable = false)
    private BigDecimal distanceFactor;

    /**
     * Gross salary
     */
    @Column(name = "gross_salary", nullable = false)
    private BigDecimal grossSalary;

    /**
     * Tax
     */
    @Column(name = "tax", nullable = false)
    private BigDecimal tax;

    /**
     * Net salary
     */
    @Column(name = "net_salary", nullable = false)
    private BigDecimal netSalary;

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