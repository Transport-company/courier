package com.training.courier;

public interface Urls {

    String ROOT = "/";

    interface CourierDeliveries {
        String PART = "courier_deliveries";
        String FULL = ROOT + "/" + PART;
    }
}