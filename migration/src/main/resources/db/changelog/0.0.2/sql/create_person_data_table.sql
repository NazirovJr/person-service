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