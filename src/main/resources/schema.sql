DROP TABLE IF EXISTS tank;
create table tank
(
   id BIGINT(20) auto_increment PRIMARY KEY,
   name varchar(255) not null,
   volume DECIMAL(10,2) not null,
   temperature DECIMAL(10,2) not null
);

DROP TABLE IF EXISTS fish;
create table fish
(
   id BIGINT auto_increment PRIMARY KEY,
   name varchar(255) not null,
   fish_type varchar(255) not null,
   price varchar(255) not null,
   creation_date DATE not null,
   tank_id BIGINT(20) not null
);