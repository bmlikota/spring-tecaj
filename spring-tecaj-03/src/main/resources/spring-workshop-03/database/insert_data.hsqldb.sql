delete from genre;
INSERT INTO genre (id, name) VALUES (1, 'Opera');
INSERT INTO genre (id, name) VALUES (2, 'Circus');
INSERT INTO genre (id, name) VALUES (3, 'Rock concert');
INSERT INTO genre (id, name) VALUES (4, 'Movie');
INSERT INTO genre (id, name) VALUES (5, 'Sport event');

delete from seating_plan;
INSERT INTO seating_plan (id, name) VALUES (1, 'No seats - free space');
INSERT INTO seating_plan (id, name) VALUES (2, 'Free seats for all');
INSERT INTO seating_plan (id, name) VALUES ( 3, 'Reserved seats in front');

delete from show;
INSERT INTO show (name, genre_id, seating_plan_id) VALUES ('Hladno pivo', 3, 1);
INSERT INTO show (name, genre_id, seating_plan_id) VALUES ('David Bowie', 3, 1);
INSERT INTO show (name, genre_id, seating_plan_id) VALUES ('Treci covjek', 4, 2);
INSERT INTO show (name, genre_id, seating_plan_id) VALUES ('Fellowship of the Ring', 4, 2);
INSERT INTO show (name, genre_id, seating_plan_id) VALUES ('Two towers', 4, 2);
INSERT INTO show (name, genre_id, seating_plan_id) VALUES ('Return of the King', 4, 2);
INSERT INTO show (name, genre_id, seating_plan_id) VALUES ('Prvenstvo u biljaru', 5, 3);

delete from performer;
INSERT INTO performer(name, p_type) VALUES ('Severina Vuckovic', 'SINGER');
INSERT INTO performer(name, p_type) VALUES ('Severina Vuckovic', 'ACTOR');
INSERT INTO performer(name, p_type) VALUES ('Vlada Divljan', 'SINGER');
INSERT INTO performer(name, p_type) VALUES ('Michael Jackson', 'SINGER');
INSERT INTO performer(name, p_type) VALUES ('Hladno pivo', 'BAND');
--
--delete from show_performer;
--INSERT INTO show_performer(show_id, performer_id) VALUES (4, 1);
--INSERT INTO show_performer(show_id, performer_id) VALUES (5, 2);
--INSERT INTO show_performer(show_id, performer_id) VALUES (2, 2);
--INSERT INTO show_performer(show_id, performer_id) VALUES (7, 3);
--INSERT INTO show_performer(show_id, performer_id) VALUES (1, 4);

