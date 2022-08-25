/* Creates relation Superhero and Assistant */
ALTER TABLE assistant
ADD COLUMN hero_id serial REFERENCES superhero;