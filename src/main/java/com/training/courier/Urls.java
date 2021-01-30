package com.training.courier;

public interface Urls {

    String ROOT = "";

    interface Couriers {
        String PART = "couriers";
        String FULL = ROOT + "/" + PART;

        interface Id {
            String PART = "{id}";
            String FULL = Couriers.FULL + "/" + PART;

            interface Salary {
                String PART = "salary";
                String FULL = Couriers.Id.FULL + "/" + PART;
            }
        }
    }

    interface CourierDeliveries {
        String PART = "deliveries";
        String FULL = ROOT + "/" + PART;

        interface Id {
            String PART = "{id}";
            String FULL = CourierDeliveries.FULL + "/" + PART;
        }

        interface Pending {
            String PENDING = "pending";
            String FULL = CourierDeliveries.FULL + "/" + PENDING;
        }
    }
}