package com.training.courier.service.impl;

import com.training.courier.feignClient.CoreFeignClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourierDeliveryServiceImpl {

    private final CoreFeignClient coreFeignClient;
}
