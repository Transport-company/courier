DROP TABLE IF EXISTS cargo CASCADE;

ALTER TABLE client DROP CONSTRAINT client_phone_number_key CASCADE;

ALTER TABLE courier_delivery RENAME TO delivery;

ALTER TABLE delivery
    DROP COLUMN sending_address_id CASCADE,
    DROP COLUMN shipping_address_id CASCADE,
    DROP COLUMN cargo_id,
    DROP CONSTRAINT courier_delivery_courier_id_fkey,
    DROP CONSTRAINT courier_delivery_client_id_fkey,
    ADD COLUMN address_id int8 NOT NULL,
    ADD COLUMN verify_code_attempts_number int2,
    ADD COLUMN delivery_attempts_number int2,
    ADD FOREIGN KEY (address_id) REFERENCES address (id),
    ADD FOREIGN KEY (courier_id) REFERENCES courier (id),
    ADD FOREIGN KEY (client_id) REFERENCES client (id);

ALTER TABLE salary
    ADD COLUMN delivery_id int8 NOT NULL UNIQUE,
    ADD FOREIGN KEY (delivery_id) REFERENCES delivery (id);