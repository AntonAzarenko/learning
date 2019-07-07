
Create Table type  (
  id BIGSERIAL NOT NULL PRIMARY KEY ,
  type VARCHAR(100) NOT NULL
);


create TABLE furnitures (
  id    BIGSERIAL   NOT NULL PRIMARY KEY,
  title  VARCHAR(45) NOT NULL,
  type_id   varchar(100),
  hight double precision  Not null,
  width double precision Not null,
  long double precision Not null,
  price DECIMAL     NOT NULL,
  CONSTRAINT fk_type_id FOREIGN KEY (type_id) REFERENCES type (id)
);

create TABLE vendors (
  id         BIGSERIAL NOT NULL PRIMARY KEY,
  title      VARCHAR(100)
);

create TABLE manufacturer (
  id BIGSERIAL NOT NULL PRIMARY KEY,
  title VARCHAR(255)
);

create TABLE vendor_to_manufacturer_map (
   id   BIGSERIAL NOT NULL PRIMARY KEY,
  vendor_id INT NOT NULL,
  manufacturer_id  INT NOT NULL,
  CONSTRAINT fk_vendor FOREIGN KEY (vendor_id) REFERENCES vendors (id),
  CONSTRAINT fk_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES manufacturer (id)
);

create TABLE maker_to_furniture_map (
id   BIGSERIAL NOT NULL PRIMARY KEY,
  furniture_id INT NOT NULL ,
  manufacturer_id INT NOT NULL ,
  CONSTRAINT fk_mebel FOREIGN KEY (furniture_id) REFERENCES furnitures (id),
  CONSTRAINT fk_maker FOREIGN KEY (manufacturer_id) REFERENCES manufacturer (id)
);

create  TABLE contacts (
  id        BIGSERIAL NOT NULL PRIMARY KEY,
  country   VARCHAR(100)NOT NULL,
  city      VARCHAR(100) NOT NULL,
  street    VARCHAR(100) NOT NULL,
  email     VARCHAR(100)NOT NULL,
  phone     VARCHAR(13)       NOT NULL,
  manufacturer_id  INT ,
  vendor_id INT ,
  CONSTRAINT fk_vendor FOREIGN KEY (vendor_id) REFERENCES vendors (id),
  CONSTRAINT fk_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES manufacturer (id)
);









