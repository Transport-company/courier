package com.training.courier.controller;

import com.training.courier.Urls;
import com.training.courier.dto.request.UpdateDeliveryRequest;
import com.training.courier.dto.response.CourierDeliveriesPageResponse;
import com.training.courier.dto.response.CourierDeliveryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Courier deliveries", description = "Courier deliveries related interaction endpoints")
public interface CourierDeliveryController {

    @Operation(summary = "Get information about courier delivery")
    @GetMapping(Urls.CourierDeliveries.Id.FULL)
    ResponseEntity<CourierDeliveryResponse> getById(@PathVariable("id") Long id);

    @Operation(summary = "Get paged information about all courier deliveries")
    @GetMapping(Urls.CourierDeliveries.FULL)
    ResponseEntity<CourierDeliveriesPageResponse> getAll(Pageable pageable);

    @Operation(summary = "Get paged information about pending courier deliveries")
    @GetMapping(Urls.CourierDeliveries.Pending.FULL)
    ResponseEntity<CourierDeliveriesPageResponse> getPendingDeliveries(Pageable pageable);

    @Operation(summary = "Edit existing courier delivery information")
    @PutMapping(Urls.CourierDeliveries.Id.FULL)
    ResponseEntity<CourierDeliveryResponse> updateDelivery(@PathVariable("id") Long id,
                                                           @RequestBody UpdateDeliveryRequest updateDeliveryRequest);
}