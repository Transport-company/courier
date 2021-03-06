package com.training.courier.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.training.courier.model.DeliveryStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * Object used to transfer data from request to controller for updating existing delivery status
 */
@Data
public class DeliveryStatusRequest {

    /**
     * Delivery status
     */
    @Schema(description = "Status", example = "IN_WAREHOUSE", required = true)
    @NotNull(message = "Status cannot be null")
    private final DeliveryStatus status;

    @JsonCreator
    public DeliveryStatusRequest(DeliveryStatus status) {
        this.status = status;
    }
}
