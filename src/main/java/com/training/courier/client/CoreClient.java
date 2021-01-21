package com.training.courier.client;

import com.training.courier.dto.request.UpdateCourierDeliveryRequest;
import com.training.courier.dto.response.CourierDeliveriesPageResponse;
import com.training.courier.dto.response.CourierDeliveryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "/deliveries",
url = "https://core_url"
//configuration =
//fallback =
)
public interface CoreClient {

    @RequestMapping(method = RequestMethod.GET, value = "/all/pending")
    CourierDeliveriesPageResponse getPendingCourierDeliveries(Long id);
    //^^ преобразовать маппером DeliveriesPageResponse в CourierDeliveriesPageResponse

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    CourierDeliveryResponse update(UpdateCourierDeliveryRequest updateCourierDeliveryRequest);
    //^^ преобразовать маппером DeliveryResponse в CourierDeliveryResponse
}