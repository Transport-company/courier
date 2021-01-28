package com.training.courier;

public interface Urls {

    String ROOT = "";
    String ID_PATH_VARIABLE = "{id}";
    String PENDING = "/pending";

    interface Courier {
        String PART = "couriers";
        String FULL = ROOT + "/" + PART;

        interface Id {
            String FULL = Courier.FULL + "/" + ID_PATH_VARIABLE;

            interface Salary {
                String PART = "salary";
                String FULL = Courier.Id.FULL + "/" + PART;
            }
        }
    }

    interface CourierDeliveries {
        String PART = "deliveries";
        String FULL = ROOT + "/" + PART;

        interface Id {
            String FULL = CourierDeliveries.FULL + "/" + ID_PATH_VARIABLE;
        }

        interface Pending {
            String FULL = CourierDeliveries.FULL + "/" + PENDING;
        }
    }
}