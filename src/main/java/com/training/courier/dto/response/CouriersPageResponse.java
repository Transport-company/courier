package com.training.courier.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
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
     * Page size
     */
    private Integer pageSize;

    /**
     * Page number
     */
    private Integer pageNumber;

    /**
     * Total number of pages
     */
    private Integer totalPages;

    /**
     * Total number of elements
     */
    private Integer totalElements;
}

    /*

    //    @Schema(description = "list of orders.")
    //    private List<OrderResponse> content;

        /**
         * Page size.
         */
//    @Schema(description = "page size")
//    private int size;
