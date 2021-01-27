package com.training.courier.controller;

import com.training.courier.Urls;
import com.training.courier.dto.request.AssignDeliveryRequest;
import com.training.courier.dto.request.UpdateDeliveryRequest;
import com.training.courier.dto.response.CourierDeliveriesPageResponse;
import com.training.courier.dto.response.CourierDeliveryResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Urls.CourierDeliveries.FULL)
public interface CourierDeliveryController {

    String ID_PATH_VARIABLE = "/{id}";
    String PENDING = "/pending";

    @GetMapping(ID_PATH_VARIABLE)
    ResponseEntity<CourierDeliveryResponse> getById(@PathVariable("id") Long id);

    @GetMapping
    ResponseEntity<CourierDeliveriesPageResponse> getAll(Pageable pageable);

    @GetMapping(PENDING)
    ResponseEntity<CourierDeliveriesPageResponse> getPendingDeliveries(Pageable pageable);

    @PutMapping(ID_PATH_VARIABLE)
    ResponseEntity<CourierDeliveryResponse> assignDelivery(@PathVariable("id") Long id,
                                                           @RequestBody AssignDeliveryRequest assignDeliveryRequest);

    @PutMapping(ID_PATH_VARIABLE)
    ResponseEntity<CourierDeliveryResponse> updateDelivery(@PathVariable("id") Long id,
                                                           @RequestBody UpdateDeliveryRequest updateDeliveryRequest);
}