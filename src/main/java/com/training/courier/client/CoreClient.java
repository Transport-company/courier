package com.training.courier.client;

import com.training.courier.dto.request.UpdateDeliveryRequest;
import com.training.courier.dto.response.CourierDeliveryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "CoreClient",
        url = "${coreUrl}",
        fallback = CoreClientFallback.class)
public interface CoreClient {

    String ID_PATH_VARIABLE = "/{id}";
    String PENDING = "/pending";  //TODO скорректировать эндпоинт в соответвии с core api

    @GetMapping(PENDING)
    List<CourierDeliveryResponse> getPendingCourierDeliveries();

    @PutMapping(ID_PATH_VARIABLE)
    CourierDeliveryResponse updateDelivery(@PathVariable("id") Long id,
                                           @RequestBody UpdateDeliveryRequest updateDeliveryRequest);
}