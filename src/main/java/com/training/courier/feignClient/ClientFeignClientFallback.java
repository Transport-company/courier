package com.training.courier.feignClient;

import com.training.courier.dto.request.client.DeliveryInClientUpdatingRequest;
import com.training.courier.dto.response.DeliveryResponse;
import org.springframework.web.bind.annotation.RequestBody;

public class ClientFeignClientFallback implements ClientFeignClient{

    @Override
    public DeliveryResponse updateDelivery(Long id,
                                           @RequestBody DeliveryInClientUpdatingRequest deliveryInClientUpdatingRequest) {
        return null;
    }
}
