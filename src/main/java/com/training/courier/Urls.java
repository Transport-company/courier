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

    interface Deliveries {
        String PART = "deliveries";
        String FULL = ROOT + "/" + PART;

        interface Id {
            String PART = "{id}";
            String FULL = Deliveries.FULL + "/" + PART;

            interface Status {
                String PART = "status";
                String FULL = Deliveries.Id.FULL + "/" + PART;
            }
        }

        interface Filter {
            String PART = "filter";
            String FULL = Deliveries.FULL + "/" + PART;
        }
    }
}
