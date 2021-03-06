CREATE TABLE weather_forecast (
	id INTEGER NOT NULL,
	place VARCHAR(40) NOT NULL,
	forecast VARCHAR(80) NOT NULL,
	PRIMARY KEY(id, place));

CREATE TABLE GENRE (
	id INTEGER NOT NULL,
	name VARCHAR(50),
	PRIMARY KEY(id));
	
CREATE TABLE SEATING_PLAN (
	id INTEGER NOT NULL,
	name VARCHAR(50),
	PRIMARY KEY(id));

CREATE TABLE SHOW (
	id IDENTITY,
	name VARCHAR(50),
	genre_id INTEGER,
	seating_plan_id INTEGER);
	
	ALTER TABLE SHOW ADD CONSTRAINT fk_Genre FOREIGN KEY (genre_id) REFERENCES GENRE(id) ON DELETE CASCADE;
	
	ALTER TABLE SHOW ADD CONSTRAINT fk_Seating_plan FOREIGN KEY (seating_plan_id) REFERENCES SEATING_PLAN(id) ON DELETE CASCADE;
	