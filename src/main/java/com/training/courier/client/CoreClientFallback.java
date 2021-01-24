package com.training.courier.client;

import com.training.courier.dto.request.UpdateDeliveryRequest;
import com.training.courier.dto.response.DeliveriesPageResponse;
import com.training.courier.dto.response.DeliveryResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoreClientFallback implements CoreClient{

    @Override
    public List<DeliveryResponse> getPendingCourierDeliveries() {
        return null;
    }

    @Override
    public DeliveryResponse updateDelivery(Long id, UpdateDeliveryRequest updateDeliveryRequest) {
        return null;
    }
}