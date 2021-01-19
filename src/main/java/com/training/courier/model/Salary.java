package com.training.courier.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
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
    private Long id;

    /**
     * Courier information
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    private Courier courier;

    /**
     * Courier salary
     */
    @Column(name = "sum")
    private BigDecimal sum;

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