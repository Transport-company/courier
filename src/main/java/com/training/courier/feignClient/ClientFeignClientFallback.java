package com.training.courier.feignClient;

import com.training.courier.dto.request.client.UpdateDeliveryClientRequest;
import com.training.courier.dto.response.CourierDeliveryResponse;
import org.springframework.web.bind.annotation.RequestBody;

public class ClientFeignClientFallback implements ClientFeignClient{

    @Override
    public CourierDeliveryResponse updateDelivery(Long id,
            @RequestBody UpdateDeliveryClientRequest updateDeliveryClientRequest) {
        return null;
    }
}