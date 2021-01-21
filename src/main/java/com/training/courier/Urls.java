package com.training.courier;

public interface Urls {

    String API = "api";
    String API_VERSION = "v1";
    String ROOT = "/" + API + "/" + API_VERSION;

    interface CourierDeliveries {
        String PART = "courier_deliveries";
        String FULL = ROOT + "/" + PART;
    }
}