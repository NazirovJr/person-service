CREATE TABLE IF NOT EXISTS medical_card
(
    id            BIGINT PRIMARY KEY,
    client_status CHAR   NOT NULL ,
    med_status    CHAR   NOT NULL ,
    registry_dt   DATE NOT NULL,
    comment       TEXT
);