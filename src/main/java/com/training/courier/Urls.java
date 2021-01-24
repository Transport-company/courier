package com.training.courier;

public interface Urls {

    String ROOT = "";
    String ID_PATH_VARIABLE = "{id}";

    interface CourierDeliveries {
        String PART = "courier_deliveries";
        String FULL = ROOT + "/" + PART;
    }

    interface Courier {
        String PART = "courier";
        String FULL = ROOT + "/" + PART;

        interface Id {
            String FULL = Courier.FULL + "/" + ID_PATH_VARIABLE;

            interface Salary {
                String PART = "salary";
                String FULL = Courier.Id.FULL + "/" + PART;
            }
        }
    }
}