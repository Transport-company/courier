package com.training.courier.feignClient;

import com.training.courier.dto.request.client.UpdateDeliveryClientRequest;
import com.training.courier.dto.response.CourierDeliveryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ClientFeignClient",
        url = "${clientUrl}",
        fallback = ClientFeignClientFallback.class)
public interface ClientFeignClient {

    String ID_PATH_VARIABLE = "/{id}";

    @PutMapping(ID_PATH_VARIABLE)
    CourierDeliveryResponse updateDelivery(@PathVariable("id") Long id,
            @RequestBody UpdateDeliveryClientRequest updateDeliveryClientRequest);
}