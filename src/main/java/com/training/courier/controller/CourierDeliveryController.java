package com.training.courier.controller;

import com.training.courier.Urls;
import com.training.courier.dto.request.UpdateCourierDeliveryRequest;
import com.training.courier.dto.response.CourierDeliveriesPageResponse;
import com.training.courier.dto.response.CourierDeliveryResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Urls.CourierDeliveries.FULL)
public interface CourierDeliveryController {

    String COURIER_DELIVERY_ID_PATH_VARIABLE = "/{id}";

    @GetMapping(COURIER_DELIVERY_ID_PATH_VARIABLE)
    ResponseEntity<CourierDeliveryResponse> getById(@PathVariable("id") Long id);

    @GetMapping("/all")
    ResponseEntity<CourierDeliveriesPageResponse> getAll(Pageable pageable);


    @GetMapping("/pending")
    ResponseEntity<CourierDeliveriesPageResponse> getPendingDeliveries(Pageable pageable);

    @PostMapping
    ResponseEntity<CourierDeliveryResponse> updateCourierDelivery(
            @RequestBody UpdateCourierDeliveryRequest updateCourierDeliveryRequest);
}

