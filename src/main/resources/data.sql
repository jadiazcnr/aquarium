INSERT INTO tank (name, volume, temperature) VALUES
  ('name1', 10, 36.5),
  ('name2', 20, 46.5);

INSERT INTO fish (name, fish_type, price, creation_date, tank_id) VALUES
  ('fish1', 'SHARK', 36.5, NOW(), 1),
  ('fish2', 'SHARK', 46.5, NOW(), 1),
  ('fish3', 'SHARK', 36.5, NOW(), 2);