package com.training.courier;

public interface Urls {

    String ROOT = "";

    interface CourierDeliveries {
        String PART = "courier_deliveries";
        String FULL = ROOT + "/" + PART;
    }

    interface Courier {
        String PART = "courier";
        String FULL = ROOT + "/" + PART;

        interface Id {
            String PART = "{id}";
            String FULL = Courier.FULL + "/" + PART;

            interface Salary {
                String PART = "salary";
                String FULL = Courier.Id.FULL + "/" + PART;
            }
        }
    }
}