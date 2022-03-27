CREATE TABLE IF NOT EXISTS medical_card
(
    id            BIGINT PRIMARY KEY,
    client_status CHAR NOT NULL ,
    med_status    CHAR NOT NULL ,
    registry_dt   DATE NOT NULL,
    comment       TEXT
);

CREATE TABLE IF NOT EXISTS contact
(
    id           BIGINT PRIMARY KEY,
    phone_number VARCHAR(32) NOT NULL,
    email        VARCHAR(128) NOT NULL UNIQUE,
    profile_link TEXT UNIQUE
    );

CREATE TABLE IF NOT EXISTS address
(
    id         BIGINT PRIMARY KEY,
    contact_id BIGINT       NOT NULL,
    country_id BIGINT       NOT NULL,
    city       VARCHAR(255) NOT NULL,
    index      INTEGER NOT NULL ,
    street     VARCHAR(255),
    building   VARCHAR(32),
    flat       VARCHAR(32),
    FOREIGN KEY (contact_id) REFERENCES contact (id)
    );

CREATE TABLE IF NOT EXISTS illness
(
    id              BIGINT PRIMARY KEY,
    medical_card_id BIGINT    NOT NULL,
    type_id         BIGINT    NOT NULL ,
    heaviness       CHAR,
    appearance_dttm TIMESTAMP NOT NULL,
    recovery_dt     DATE      NOT NULL,
    FOREIGN KEY (medical_card_id) REFERENCES medical_card (id)
    );

CREATE TABLE IF NOT EXISTS person_data
(
    id              BIGINT PRIMARY KEY,
    last_name       VARCHAR(255) NOT NULL,
    first_name      VARCHAR(255) NOT NULL,
    birth_dt        DATE         NOT NULL,
    age             SMALLINT,
    sex             CHAR         NOT NULL,
    contact_id      BIGINT       NOT NULL,
    medical_card_id BIGINT       NOT NULL UNIQUE,
    parent_id       BIGINT,
    FOREIGN KEY (contact_id) REFERENCES contact (id),
    FOREIGN KEY (medical_card_id) REFERENCES medical_card (id)
    );

ALTER TABLE person_data ADD CONSTRAINT parent_constraint FOREIGN KEY (parent_id) REFERENCES person_data(id);