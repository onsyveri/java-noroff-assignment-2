/* Creates many to many realtion between Superhero and Powers */
DROP TABLE IF EXISTS superhero_powers;

CREATE TABLE superhero_powers (
	hero_id serial REFERENCES superhero,
	powers_id serial REFERENCES powers,
	PRIMARY KEY (hero_id, powers_id)
);