package com.training.courier.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Data;

/**
 * Paged response for courier request
 */
@Schema(description = "Paged response for courier request")
@Data
public class CouriersPageResponse {

    /**
     * List of couriers
     */
    @Schema(description = "List of couriers")
    private List<CourierResponse> content;

    /**
     * Page size
     */
    @Schema(description = "Page size")
    private Integer pageSize;

    /**
     * Page number
     */
    @Schema(description = "Page number")
    private Integer pageNumber;

    /**
     * Total number of pages
     */
    @Schema(description = "Total number of pages")
    private Integer totalPages;

    /**
     * Total number of elements
     */
    @Schema(description = "Total number of elements")
    private Integer totalElements;
}