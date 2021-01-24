package com.training.courier.client;

import com.training.courier.dto.request.UpdateDeliveryRequest;
import com.training.courier.dto.response.DeliveriesPageResponse;
import com.training.courier.dto.response.DeliveryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "CoreClient",
        value = "core",
        url = "https://core_url",
//        configuration = FeignClientsConfiguration.class,
        fallback = CoreClientFallback.class)
public interface CoreClient {

    String ID_PATH_VARIABLE = "/{id}";

    @RequestMapping(method = RequestMethod.GET, value = "/pending")
        //TODO скорректировать эндпоинт
    List<DeliveryResponse> getPendingCourierDeliveries();

    @RequestMapping(method = RequestMethod.PUT, value = ID_PATH_VARIABLE, consumes = "application/json")
    DeliveryResponse updateDelivery(@PathVariable("id") Long id, UpdateDeliveryRequest updateDeliveryRequest);
}