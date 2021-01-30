package com.training.courier.feignClient;

import com.training.courier.dto.request.core.DeliveryInCoreUpdatingRequest;
import com.training.courier.dto.response.CourierDeliveryResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class CoreFeignClientFallback implements CoreFeignClient {

    @Override
    public List<CourierDeliveryResponse> getPendingCourierDeliveries(String filter) {
        return new ArrayList<CourierDeliveryResponse>();
    }

    @Override
    public CourierDeliveryResponse updateDelivery(Long id,
            @RequestBody DeliveryInCoreUpdatingRequest deliveryInCoreUpdatingRequest) {
        return null;
    }
}