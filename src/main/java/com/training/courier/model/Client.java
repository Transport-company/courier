package com.training.courier.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Recipient client entity
 */
@Entity
@Table(name = "client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    /**
     * Unique identifier
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
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
     * Email
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

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
