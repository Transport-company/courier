package com.training.courier.feignClient;

import com.training.courier.dto.request.core.DeliveryInCoreUpdatingRequest;
import com.training.courier.dto.response.DeliveryResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;

public class CoreFeignClientFallback implements CoreFeignClient {

    @Override
    public DeliveryResponse getDeliveryResponse(Long id) {
        return null;
    }

    @Override
    public List<DeliveryResponse> getPendingDeliveries(String filter) {
        return new ArrayList<DeliveryResponse>();
    }

    @Override
    public DeliveryResponse updateDelivery(Long id,
                                           @RequestBody DeliveryInCoreUpdatingRequest deliveryInCoreUpdatingRequest) {
        return null;
    }
}
