package com.training.courier.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Paged response for courier request
 */
@Data
public class CouriersPageResponse {

    /**
     * List of couriers
     */
    private List<CourierResponse> content;

    /**
     *  Page size
     */
    private Integer pageSize;

    /**
     * Page number
     */
    private Integer pageNumber;

    /**
     *
     */
    private Integer totalPages;

    private Integer totalElements;
}

/*

//    @Schema(description = "list of orders.")
//    private List<OrderResponse> content;

    /**
     * Page size.
     */
    @Schema(description = "page size")
    private int size;

    /**
     * Page number.
     */
    @Schema(description = "page number")
    private int number;

    /**
     * Total number of pages.
     */
    @Schema(description = "total number of pages")
    private int totalPages;

    /**
     * Total number of elements.
     */


