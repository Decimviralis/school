CREATE TABLE accountant
(
    id BIGINT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(75) NOT NULL,
    salary DECIMAL(10,0) NOT NULL,
    phone VARCHAR(12) NOT NULL
);
CREATE TABLE act
(
    id BIGINT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description LONGTEXT NOT NULL,
    cost DECIMAL(10,0) NOT NULL,
    adoption_date DATE NOT NULL
);
CREATE TABLE pupil
(
    id BIGINT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(75) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    age INT NOT NULL,
    grade VARCHAR(5) NOT NULL
);
CREATE TABLE receipt
(
    id BIGINT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description VARCHAR(300) NOT NULL,
    sum DECIMAL(10,0) NOT NULL,
    date DATE NOT NULL,
    pupil_id BIGINT UNSIGNED NOT NULL,
    act_id BIGINT UNSIGNED NOT NULL,
    accountant_id BIGINT UNSIGNED NOT NULL
);
CREATE UNIQUE INDEX id ON accountant (id);
CREATE UNIQUE INDEX unique_phone ON accountant (phone);
CREATE UNIQUE INDEX id ON act (id);
CREATE UNIQUE INDEX id ON pupil (id);
ALTER TABLE receipt ADD FOREIGN KEY (pupil_id) REFERENCES pupil (id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE receipt ADD FOREIGN KEY (act_id) REFERENCES act (id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE receipt ADD FOREIGN KEY (accountant_id) REFERENCES accountant (id) ON DELETE CASCADE ON UPDATE CASCADE;
CREATE UNIQUE INDEX id ON receipt (id);