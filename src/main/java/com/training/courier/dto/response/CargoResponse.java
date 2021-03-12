package com.training.courier.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * Response object for cargo parameters request
 */
@Data
@Builder
public class CargoResponse {

    /**
     * Weight
     */
    @Schema(description = "Weight", example = "10.0")
    private final Float weight;

    /**
     * Length
     */
    @Schema(description = "Length", example = "0.5")
    private final Float length;

    /**
     * Width
     */
    @Schema(description = "Width", example = "0.4")
    private final Float width;

    /**
     * Height
     */
    @Schema(description = "Height", example = "0.3")
    private final Float height;
}
