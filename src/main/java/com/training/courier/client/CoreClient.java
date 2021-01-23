package com.training.courier.client;

import com.training.courier.dto.request.UpdateDeliveryRequest;
import com.training.courier.dto.response.DeliveriesPageResponse;
import com.training.courier.dto.response.DeliveryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "/deliveries",
url = "https://core_url"
//configuration =
//fallback =
)
public interface CoreClient {

    @RequestMapping(method = RequestMethod.GET, value = "/pending")
    DeliveriesPageResponse getPendingCourierDeliveries();

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
    DeliveryResponse updateDelivery(@PathVariable("id") Long id, UpdateDeliveryRequest updateDeliveryRequest);
}