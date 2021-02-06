package com.training.courier.feignClient;

import com.training.courier.dto.request.client.DeliveryInClientUpdatingRequest;
import com.training.courier.dto.response.DeliveryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ClientFeignClient",
        url = "${client.deliveriesApi.url}",
        fallback = ClientFeignClientFallback.class)
public interface ClientFeignClient {

    String ID_PATH_VARIABLE = "/{id}";

    @PatchMapping(ID_PATH_VARIABLE)
    DeliveryResponse updateDelivery(@PathVariable("id") Long id,
                                    @RequestBody DeliveryInClientUpdatingRequest deliveryInClientUpdatingRequest);
}
