package com.training.courier.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


/**
 * Courier entity
 */
@Entity
@Table(name = "courier")
@Data
public class Courier {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * First name
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * Middle name
     */
    @Column(name = "middle_name", nullable = false)
    private String middleName;

    /**
     * Last name
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * Date of birth
     */
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    /**
     * Phone number
     */
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    /**
     * Working city
     */
    @Column(name = "city", nullable = false)
    private String city;

    /**
     * Deliveries belonging to the courier
     */
    @OneToMany(mappedBy = "courier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Delivery> courierDeliveries;

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
