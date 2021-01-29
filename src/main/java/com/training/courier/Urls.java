package com.training.courier;

public interface Urls {

    String ROOT = "";

    interface Couriers {
        String PART = "couriers";
        String FULL = ROOT + "/" + PART;
    }

    interface CourierDeliveries {
        String PART = "deliveries";
        String FULL = ROOT + "/" + PART;
    }
}