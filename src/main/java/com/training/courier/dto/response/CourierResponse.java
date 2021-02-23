package com.training.courier.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Response object for courier request
 */
@Data
public class CourierResponse {

    /**
     * Unique identifier
     */
    @Schema(description = "Unique identifier",
            example = "1")
    private Long id;

    /**
     * First name
     */
    @Schema(description = "First name",
            example = "Ivan")
    private String firstName;

    /**
     * Middle name
     */
    @Schema(description = "Middle name",
            example = "Ivanovich")
    private String middleName;

    /**
     * Last name
     */
    @Schema(description = "Last name",
            example = "Ivanov")
    private String lastName;

    /**
     * Date of birth
     */
    @Schema(description = "Date of birth",
            example = "10.01.1980")
    private LocalDate birthday;

    /**
     * Phone number
     */
    @Schema(description = "Phone number",
            example = "89085554466")
    private String phoneNumber;

    /**
     * Working city
     */
    @Schema(description = "Working city",
            example = "Moscow")
    private String city;

    /**
     * State showing whether the courier is active or not
     */
    @Schema(description = "State showing whether the courier is active or not",
            example = "true")
    private Boolean isActive;

    /**
     * Number of active current tasks
     */
    @Schema(description = "Number of active current tasks",
            example = "2")
    private Integer activeTasksNumber;

    /**
     * Registration time
     */
    @Schema(description = "Registration time")
    private LocalDateTime created;

    /**
     * Update time
     */
    @Schema(description = "Update time")
    private LocalDateTime updated;
}
