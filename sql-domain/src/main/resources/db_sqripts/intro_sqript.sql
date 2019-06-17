insert  into contacts (email, country, street, telephone) values
  ('factoryOne@gmail.com', 'Belarus', 'Lazo 103b', '+375264987561'),
  ('factoryTwo@gmail.com', 'Switzerland','5-shtrasse', '+784632598456'),
  ('vendorOne@gmail.com', 'Belarus', 'Minsk', '+345295698952'),
  ('vendorTwo@gmail.com', 'Belarus', 'Vitebsk', '+345295123547');

insert into maker (title) values
  ('Geos Ideal'),
  ('Ikea');

insert into furniture (title, price, contact_id) values
  ('LEDA', '1025', 1),
  ('малютка', '320', 2);

insert into furniture_type (furniture_id, type) values
  (1, 'kitchen'),
  (2, 'table');

insert into vendor (title, contact_id) values
   ('dev.by', 3),
   ('21vek',4);