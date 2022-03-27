CREATE TABLE IF NOT EXISTS role
(
    id    BIGINT PRIMARY KEY DEFAULT NEXTVAL('custom_serial'),
    value VARCHAR(20) NOT NULL UNIQUE,
    CHECK ( value = 'ADMIN' OR value = 'PATIENT' )
    );

CREATE TABLE IF NOT EXISTS role_person
(
    person_data_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (person_data_id, role_id),
    FOREIGN KEY (person_data_id) REFERENCES person_data(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE
    );

ALTER TABLE person_data ADD COLUMN email VARCHAR(128) UNIQUE;
ALTER TABLE person_data ADD COLUMN password VARCHAR(255);