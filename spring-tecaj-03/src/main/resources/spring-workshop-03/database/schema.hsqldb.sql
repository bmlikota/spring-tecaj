CREATE TABLE GENRE (
	id INTEGER IDENTITY NOT NULL,
	name VARCHAR(50) NOT NULL UNIQUE);
	
CREATE TABLE SEATING_PLAN (
	id INTEGER IDENTITY NOT NULL,
	name VARCHAR(50) NOT NULL UNIQUE);

CREATE TABLE SHOW (
	id IDENTITY NOT NULL,
	name VARCHAR(50) NOT NULL UNIQUE,
	genre_id INTEGER,
	seating_plan_id INTEGER);
	
CREATE TABLE PERFORMER (
	id IDENTITY NOT NULL,
	name VARCHAR(50) NOT NULL,
	p_type VARCHAR(50));
	
CREATE TABLE SHOW_PERFORMER (
	show_id INTEGER,
	performer_id INTEGER);
	
	ALTER TABLE SHOW ADD CONSTRAINT fk_Genre FOREIGN KEY (genre_id) REFERENCES GENRE(id) ON DELETE CASCADE;
	
	ALTER TABLE SHOW ADD CONSTRAINT fk_Seating_plan FOREIGN KEY (seating_plan_id) REFERENCES SEATING_PLAN(id) ON DELETE CASCADE;
	
	ALTER TABLE SHOW_PERFORMER ADD CONSTRAINT fk_show FOREIGN KEY (show_id) REFERENCES SHOW(id) ON DELETE CASCADE;
	
	ALTER TABLE SHOW_PERFORMER ADD CONSTRAINT fk_performer FOREIGN KEY (performer_id) REFERENCES PERFORMER(id) ON DELETE CASCADE;