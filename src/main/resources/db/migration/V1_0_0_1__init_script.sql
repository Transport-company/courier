CREATE TABLE IF NOT EXISTS address (
    id                             bigserial          NOT NULL PRIMARY KEY,
    region                       varchar(32)    NOT NULL,
    city                          varchar(32)    NOT NULL,
    street                       varchar(32),
    house                       varchar(4)      NOT NULL,
    apartment                 varchar(4),
    created                     TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated                     TIMESTAMP    NOT NULL);

CREATE TABLE IF NOT EXISTS cargo (
    id                             bigserial          NOT NULL PRIMARY KEY,
    weight                      float               NOT NULL,
    length                       float              NOT NULL,
    width                        float              NOT NULL,
    height                       float              NOT NULL,
    created                     TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated                     TIMESTAMP    NOT NULL);

CREATE TABLE IF NOT EXISTS client (
    id                             bigserial          NOT NULL PRIMARY KEY,
    name                        varchar(32)    NOT NULL UNIQUE,
    email                         varchar(32)   NOT NULL UNIQUE,
    created                     TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated                     TIMESTAMP    NOT NULL);

CREATE TABLE IF NOT EXISTS courier (
    id                             bigserial          NOT NULL PRIMARY KEY,
    name                        varchar(32)    NOT NULL UNIQUE,
    city                          varchar(32)    NOT NULL,
    created                     TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated                     TIMESTAMP    NOT NULL);

CREATE TABLE IF NOT EXISTS delivery (
    id                             bigserial          NOT NULL PRIMARY KEY,
    cargo_id                    int8               NOT NULL,
    courier_id                  int8               NOT NULL,
    client_id                    int8               NOT NULL,
    sending_address_id     int8                NOT NULL,
    shipping_address_id     int8               NOT NULL,
    enabled_notifications   boolean          NOT NULL,
    code                         varchar(4),
    status                       varchar(32)    NOT NULL,
    created                     TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated                     TIMESTAMP    NOT NULL,
    FOREIGN KEY (cargo_id)               REFERENCES cargo (id),
    FOREIGN KEY (courier_id)              REFERENCES courier (id),
    FOREIGN KEY (client_id)                REFERENCES client (id),
    FOREIGN KEY (sending_address_id) REFERENCES address (id),
    FOREIGN KEY (shipping_address_id) REFERENCES address (id)
);

CREATE TABLE IF NOT EXISTS salary (
    id                             bigserial          NOT NULL PRIMARY KEY,
    courier_id                   int8               NOT NULL,
    sum                          numeric          NOT NULL,
    created                     TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated                     TIMESTAMP    NOT NULL,
    FOREIGN KEY (courier_id)              REFERENCES courier (id));