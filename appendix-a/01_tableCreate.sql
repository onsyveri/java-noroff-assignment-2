/* Ensures we dont try re-create the table */
DROP TABLE IF EXISTS superhero;

CREATE TABLE superhero (
    hero_id serial PRIMARY KEY,
    hero_name varchar(50) NOT NULL,
    hero_alias varchar(50) NOT NULL,
	hero_origin varchar(150) NOT NULL
);


DROP TABLE IF EXISTS assistant;

CREATE TABLE assistant (
	assist_id serial PRIMARY KEY,
	assist_name varchar(50) NOT NULL
);


DROP TABLE IF EXISTS powers;

CREATE TABLE powers (
	powers_id serial PRIMARY KEY,
	powers_name varchar(50) NOT NULL,
	powers_desc varchar(150) NOT NULL
);