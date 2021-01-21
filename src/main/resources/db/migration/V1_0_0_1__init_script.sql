CREATE TABLE IF NOT EXISTS address (
    id                             bigserial          PRIMARY KEY,
    region                       varchar(255)   NOT NULL,
    city                          varchar(255)   NOT NULL,
    street                       varchar(255),
    house                       varchar(32)     NOT NULL,
    apartment                 varchar(32),
    created                     TIMESTAMP     NOT NULL,
    updated                     TIMESTAMP    NOT NULL);

CREATE TABLE IF NOT EXISTS cargo (
    id                             bigserial          PRIMARY KEY,
    weight                      float               NOT NULL,
    length                       float              NOT NULL,
    width                        float              NOT NULL,
    height                       float              NOT NULL,
    created                     TIMESTAMP     NOT NULL,
    updated                     TIMESTAMP    NOT NULL);

CREATE TABLE IF NOT EXISTS client (
    id                             bigserial          PRIMARY KEY,
    name                        varchar(32)    NOT NULL UNIQUE,
    email                         varchar(32)   NOT NULL UNIQUE,
    created                     TIMESTAMP     NOT NULL,
    updated                     TIMESTAMP    NOT NULL);

CREATE TABLE IF NOT EXISTS courier (
    id                             bigserial          PRIMARY KEY,
    first_name                  varchar(32)    NOT NULL,
    last_name                  varchar(32)    NOT NULL,
    age                           int2               NOT NULL,
    city                           varchar(32)   NOT NULL,
    created                     TIMESTAMP     NOT NULL,
    updated                     TIMESTAMP    NOT NULL);

CREATE TABLE IF NOT EXISTS courier_delivery (
    id                             bigserial          PRIMARY KEY,
    cargo_id                    int8               NOT NULL,
    courier_id                  int8               NOT NULL,
    client_id                    int8               NOT NULL,
    sending_address_id     int8                NOT NULL,
    shipping_address_id     int8               NOT NULL,
    code                         varchar(4),
    status                       varchar(32)    NOT NULL,
    created                     TIMESTAMP     NOT NULL,
    updated                     TIMESTAMP    NOT NULL,
    FOREIGN KEY (cargo_id)               REFERENCES cargo (id),
    FOREIGN KEY (courier_id)              REFERENCES courier (id),
    FOREIGN KEY (client_id)                REFERENCES client (id),
    FOREIGN KEY (sending_address_id) REFERENCES address (id),
    FOREIGN KEY (shipping_address_id) REFERENCES address (id)
);

CREATE TABLE IF NOT EXISTS salary (
    id                             bigserial          PRIMARY KEY,
    courier_id                   int8               NOT NULL,
    sum                          numeric          NOT NULL,
    created                     TIMESTAMP     NOT NULL,
    updated                     TIMESTAMP    NOT NULL,
    FOREIGN KEY (courier_id)              REFERENCES courier (id));