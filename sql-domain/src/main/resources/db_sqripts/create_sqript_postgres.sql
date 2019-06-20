-- Table contains contacts information of makers and vendors.
-- It doesn't have foreign keys.
-- ----------------------------------------------------------
-- FIELDS:
-- id - unique identification
-- email - email
-- country - Country of registration
-- street - street of registration
-- telephone - phone number of company
CREATE TABLE contacts (
  id        BIGSERIAL NOT NULL PRIMARY KEY,
  email     VARCHAR(100),
  country   VARCHAR(45),
  street    VARCHAR(100),
  telephone INT       NOT NULL
);

-- ----------------------------------------------
-- Table contains information about mebel product.
-- It doesn't have foreign keys.
-- ----------------------------------------------
--FIELDS
-- id - unique identification
-- title -  name of any product.
-- price - price of any product
CREATE TABLE furniture (
  id    BIGSERIAL   NOT NULL PRIMARY KEY,
  title  VARCHAR(45) NOT NULL,
  price DECIMAL     NOT NULL
);

-- ------------------------------------------------------------------
-- Table contains furniture_type and 'furniture_id' references to furniture 'id'
-- ------------------------------------------------------------------
--FIELDS
CREATE TABLE furniture_type (
  furniture_id INT NOT NULL,
  type     VARCHAR(255),
  CONSTRAINT fk_mebel_type FOREIGN KEY (furniture_id) REFERENCES furniture (id)
);

-- Table contains information about vendors also references to contacts
-- It has foreign key 'contact_id' to reference contacts 'id'
CREATE TABLE vendor (
  id         BIGSERIAL NOT NULL PRIMARY KEY,
  title      VARCHAR(100),
  contact_id INT       NOT NULL,
  CONSTRAINT fk_vendors_contact FOREIGN KEY (contact_id) REFERENCES contacts (id)
);

CREATE TABLE maker (
  id BIGSERIAL NOT NULL PRIMARY KEY,
  title VARCHAR(255),
  contact_id INT       NOT NULL,
  CONSTRAINT fk_maker_contact FOREIGN KEY (contact_id) REFERENCES contacts (id)
);

-- Table contains demensions information for each product.
CREATE TABLE dimentions (
  id        BIGSERIAL NOT NULL PRIMARY KEY,
  height    DOUBLE PRECISION,
  width     DOUBLE PRECISION,
  thickness DOUBLE PRECISION,
  furniture_id  INT,
  CONSTRAINT fk_demensions_mebel FOREIGN KEY (furniture_id) REFERENCES furniture (id)
);

CREATE TABLE vendor_has_makers (
  vendor_id INT NOT NULL,
  maker_id  INT NOT NULL,
  CONSTRAINT fk_vendor FOREIGN KEY (vendor_id) REFERENCES vendor (id),
  CONSTRAINT fk_maker FOREIGN KEY (maker_id) REFERENCES maker (id)
);

CREATE TABLE maker_has_mebel (
  furniture_id INT NOT NULL ,
  maker_id INT NOT NULL ,
  CONSTRAINT fk_mebel FOREIGN KEY (furniture_id) REFERENCES furniture (id),
  CONSTRAINT fk_maker FOREIGN KEY (maker_id) REFERENCES maker (id)
);









