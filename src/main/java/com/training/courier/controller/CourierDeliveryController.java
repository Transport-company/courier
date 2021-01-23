package com.training.courier.controller;

import com.training.courier.Urls;
import com.training.courier.dto.request.AssignDeliveryRequest;
import com.training.courier.dto.request.UpdateDeliveryRequest;
import com.training.courier.dto.response.DeliveriesPageResponse;
import com.training.courier.dto.response.DeliveryResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Urls.CourierDeliveries.FULL)
public interface CourierDeliveryController {

    String ID_PATH_VARIABLE = "/{id}";

    @GetMapping(ID_PATH_VARIABLE)
    ResponseEntity<DeliveryResponse> getById(@PathVariable("id") Long id);

    @GetMapping("/all")
    ResponseEntity<DeliveriesPageResponse> getAll(Pageable pageable);

    @GetMapping("/pending")
    ResponseEntity<DeliveriesPageResponse> getPendingDeliveries(Pageable pageable);

    @PutMapping(ID_PATH_VARIABLE)
    ResponseEntity<DeliveryResponse> assignDelivery(@PathVariable("id") Long id,
                                                    @RequestBody AssignDeliveryRequest assignDeliveryRequest);

    @PutMapping(ID_PATH_VARIABLE)
    ResponseEntity<DeliveryResponse> updateDelivery(@PathVariable("id") Long id,
                                                    @RequestBody UpdateDeliveryRequest updateDeliveryRequest);
}

