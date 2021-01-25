CREATE TABLE IF NOT EXISTS address (
    id                       int8                PRIMARY KEY,
    region                   varchar(128)        NOT NULL,
    city                     varchar(128)        NOT NULL,
    street                   varchar(255),
    house                    varchar(16)         NOT NULL,
    apartment                varchar(16),
    created                  timestamp           NOT NULL,
    updated                  timestamp           NOT NULL);

CREATE TABLE IF NOT EXISTS cargo (
    id                       int8                PRIMARY KEY,
    weight                   float4              NOT NULL,
    length                   float4              NOT NULL,
    width                    float4              NOT NULL,
    height                   float4              NOT NULL,
    created                  timestamp           NOT NULL,
    updated                  timestamp           NOT NULL);

CREATE TABLE IF NOT EXISTS client (
    id                       int8                PRIMARY KEY,
    first_name               varchar(32)         NOT NULL,
    middle_name              varchar(32)         NOT NULL,
    last_name                varchar(32)         NOT NULL,
    birthday                 date                NOT NULL,
    phone_number             varchar(11)         NOT NULL UNIQUE,
    email                    varchar(32)         NOT NULL UNIQUE,
    created                  timestamp           NOT NULL,
    updated                  timestamp           NOT NULL);

CREATE TABLE IF NOT EXISTS courier (
    id                       bigserial           PRIMARY KEY,
    first_name               varchar(32)         NOT NULL,
    middle_name              varchar(32)         NOT NULL,
    last_name                varchar(32)         NOT NULL,
    birthday                 date                NOT NULL,
    phone_number             varchar(11)         NOT NULL UNIQUE,
    city                     varchar(128)        NOT NULL,
    created                  timestamp           NOT NULL,
    updated                  timestamp           NOT NULL);

CREATE TABLE IF NOT EXISTS courier_delivery (
    id                       int8                PRIMARY KEY,
    cargo_id                 int8                NOT NULL,
    courier_id               int8,
    client_id                int8                NOT NULL,
    sending_address_id       int8                NOT NULL,
    shipping_address_id      int8                NOT NULL,
    code                     varchar(4),
    courier_delivery_status  varchar(16)         NOT NULL,
    created                  timestamp           NOT NULL,
    updated                  timestamp           NOT NULL,
    FOREIGN KEY (cargo_id)            REFERENCES cargo (id),
    FOREIGN KEY (courier_id)          REFERENCES courier (id),
    FOREIGN KEY (client_id)           REFERENCES client (id),
    FOREIGN KEY (sending_address_id)  REFERENCES address (id),
    FOREIGN KEY (shipping_address_id) REFERENCES address (id));

CREATE TABLE IF NOT EXISTS salary (
    id                       bigserial           PRIMARY KEY,
    courier_id               int8                NOT NULL,
    date                     date                NOT NULL,
    base_rate                numeric(19, 2)      NOT NULL,
    weight_factor            numeric(5, 2)       NOT NULL,
    volume_factor            numeric(5, 2)       NOT NULL,
    distance_factor          numeric(5, 2)       NOT NULL,
    gross_salary             numeric(19, 2)      NOT NULL,
    tax                      numeric(5, 2)       NOT NULL,
    net_salary               numeric(19, 2)      NOT NULL,
    created                  timestamp           NOT NULL,
    updated                  timestamp           NOT NULL,
    FOREIGN KEY (courier_id)          REFERENCES courier (id));