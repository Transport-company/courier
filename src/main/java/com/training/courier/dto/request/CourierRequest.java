package com.training.courier.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Object used to transfer data from request to controller
 */
@Data
public class CourierRequest {

    /**
     * First name
     */
    @Schema(description = "First name", example = "Ivan", required = true)
    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 32, message = "First name must be between 2 and 32 characters")
    private final String firstName;

    /**
     * Middle name
     */
    @Schema(description = "Middle name", example = "Ivanovich", required = true)
    @NotBlank(message = "Middle name cannot be blank")
    @Size(min = 2, max = 32, message = "Middle name must be between 2 and 32 characters")
    private final String middleName;

    /**
     * Last name
     */
    @Schema(description = "Last name", example = "Ivanov", required = true)
    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, max = 32, message = "Last name must be between 2 and 32 characters")
    private final String lastName;

    /**
     * Date of birth
     */
    @Schema(description = "Date of birth", example = "10.01.1980", required = true)
    @NotNull(message = "Date cannot be null")
    private final LocalDate birthday;

    /**
     * Phone number
     */
    @Schema(description = "Phone number", example = "89085554466", required = true)
    @NotNull(message = "Phone number cannot be null")
    @Size(min = 11, max = 11, message = "Phone number must contain 11 digits")
    @Pattern(regexp = "\\d{11}", message = "Phone number must be digits")
    private final String phoneNumber;

    /**
     * Working city
     */
    @Schema(description = "Working city", example = "Moscow", required = true)
    @NotBlank(message = "Working city cannot be blank")
    @Size(min = 2, max = 128, message = "Working city must be between 2 and 32 characters")
    private final String city;

    /**
     * State showing whether the courier is active or not
     */
    @Schema(description = "State showing whether the courier is active or not", example = "true", required = true)
    @NotNull(message = "Status cannot be null")
    private final Boolean active;
}
