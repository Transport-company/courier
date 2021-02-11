package com.training.courier.config;

import com.training.courier.mapper.fromModel.CourierToCourierResponseConverter;
import com.training.courier.mapper.fromModel.CouriersPageToCouriersPagedResponseConverter;
import com.training.courier.mapper.toModel.CourierRequestToCourierConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        CourierToCourierResponseConverter courierToCourierResponseConverter =
                new CourierToCourierResponseConverter();
        registry.addConverter(courierToCourierResponseConverter);

        CouriersPageToCouriersPagedResponseConverter
                couriersPageToCouriersPagedResponseConverter =
                new CouriersPageToCouriersPagedResponseConverter(courierToCourierResponseConverter);
        registry.addConverter(couriersPageToCouriersPagedResponseConverter);

        CourierRequestToCourierConverter courierRequestToCourierConverter =
                new CourierRequestToCourierConverter();
        registry.addConverter(courierRequestToCourierConverter);
    }
}
