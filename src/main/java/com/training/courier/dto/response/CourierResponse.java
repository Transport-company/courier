package com.training.courier.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * Response object for courier request
 */
@Data
@Builder
public class CourierResponse {

    /**
     * Unique identifier
     */
    @Schema(description = "Unique identifier", example = "1")
    private final Long id;

    /**
     * First name
     */
    @Schema(description = "First name", example = "Ivan")
    private final String firstName;

    /**
     * Middle name
     */
    @Schema(description = "Middle name", example = "Ivanovich")
    private final String middleName;

    /**
     * Last name
     */
    @Schema(description = "Last name", example = "Ivanov")
    private final String lastName;

    /**
     * Date of birth
     */
    @Schema(description = "Date of birth", example = "10.01.1980")
    private final LocalDate birthday;

    /**
     * Phone number
     */
    @Schema(description = "Phone number", example = "89085554466")
    private final String phoneNumber;

    /**
     * Working city
     */
    @Schema(description = "Working city", example = "Moscow")
    private final String city;

    /**
     * State showing whether the courier is active or not
     */
    @Schema(description = "State showing whether the courier is active or not", example = "true")
    private final Boolean active;

    /**
     * Number of active current tasks
     */
    @Schema(description = "Number of active current tasks", example = "2")
    private final Integer tasksNumber;

    /**
     * Registration time
     */
    @Schema(description = "Registration time")
    private final LocalDateTime created;

    /**
     * Update time
     */
    @Schema(description = "Update time")
    private final LocalDateTime updated;
}
