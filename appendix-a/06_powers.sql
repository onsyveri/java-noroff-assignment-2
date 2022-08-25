/* Inserts powers */
INSERT INTO powers (powers_name, powers_desc) VALUES ('Fly', 'Allows the superhero to fly');
INSERT INTO powers (powers_name, powers_desc) VALUES ('Fireball', 'Allows the superhero to make a fireball');
INSERT INTO powers (powers_name, powers_desc) VALUES ('Mind-Control', 'Allows the superhero to control minds');
INSERT INTO powers (powers_name, powers_desc) VALUES ('Super-Strength', 'Makes the superhero super strong');

/* One hero many powers */
INSERT INTO superhero_powers (hero_id, powers_id) VALUES(1,1);
INSERT INTO superhero_powers (hero_id, powers_id) VALUES(1,2);
INSERT INTO superhero_powers (hero_id, powers_id) VALUES(1,4);

/* One power many heros */
INSERT INTO superhero_powers (hero_id, powers_id) VALUES(1,3);
INSERT INTO superhero_powers (hero_id, powers_id) VALUES(2,3);
INSERT INTO superhero_powers (hero_id, powers_id) VALUES(3,3);