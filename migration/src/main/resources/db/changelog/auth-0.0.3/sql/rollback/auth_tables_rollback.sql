DROP TABLE IF EXISTS role, role_person CASCADE;

ALTER TABLE person_data DROP COLUMN email;
ALTER TABLE person_data DROP COLUMN password;