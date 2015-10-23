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
INSERT INTO show (id, name, genre_id, seating_plan_id) VALUES (1, 'Hladno pivo', 3, 1);
INSERT INTO show (id, name, genre_id, seating_plan_id) VALUES (2, 'David Bowie', 3, 1);
INSERT INTO show (id, name, genre_id, seating_plan_id) VALUES (3, 'Treci covjek', 4, 2);
INSERT INTO show (id, name, genre_id, seating_plan_id) VALUES (4, 'Fellowship of the Ring', 4, 2);
INSERT INTO show (id, name, genre_id, seating_plan_id) VALUES (5, 'Two towers', 4, 2);
INSERT INTO show (id, name, genre_id, seating_plan_id) VALUES (6, 'Return of the King', 4, 2);
INSERT INTO show (id, name, genre_id, seating_plan_id) VALUES (7, 'Prvenstvo u biljaru', 5, 3);

delete from performer;
INSERT INTO performer(id, name, p_type) VALUES (1, 'Severina Vuckovic', 'SINGER');
INSERT INTO performer(id, name, p_type) VALUES (2, 'Severina Vuckovic', 'ACTOR');
INSERT INTO performer(id, name, p_type) VALUES (3, 'Vlada Divljan', 'SINGER');
INSERT INTO performer(id, name, p_type) VALUES (4, 'Michael Jackson', 'SINGER');
INSERT INTO performer(id, name, p_type) VALUES (5, 'Hladno pivo', 'BAND');
INSERT INTO performer(id, name, p_type) VALUES (6, 'David Bowie', 'SINGER');


--delete from show_performer;
INSERT INTO show_performer(show_id, performer_id) VALUES (4, 1);
INSERT INTO show_performer(show_id, performer_id) VALUES (5, 2);
INSERT INTO show_performer(show_id, performer_id) VALUES (2, 6);
INSERT INTO show_performer(show_id, performer_id) VALUES (7, 3);
INSERT INTO show_performer(show_id, performer_id) VALUES (1, 5);

