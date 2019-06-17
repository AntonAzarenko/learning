INSERT  INTO contacts (email, country, street, telephone) VALUES
  ('factoryOne@gmail.com', 'Belarus', 'Lazo 103b', '+375264987561'),
  ('factoryTwo@gmail.com', 'Switzerland','5-shtrasse', '+784632598456');

INSERT INTO maker (title) VALUES
  ('Geos Ideal'),
  ('Ikea');

Insert INTO mebel (title, price, contact_id) VALUES
  ('LEDA', '1025', 1),
  ('малютка', '320', 2);

INSERT INTO mebel_type (mebel_id, type) VALUES
  (1, 'kitchen'),
  (2, 'table');