CREATE TABLE IF NOT EXISTS heroes (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	name TEXT NOT NULL,
	canonical_name TEXT NOT NULL,
	health INTEGER NOT NULL,
	armor INTEGER NOT NULL,
	shield INTEGER NOT NULL,
	real_name TEXT,
	age INT,
	nationality TEXT,
	occupation TEXT,
	base_of_operation TEXT,
	affiliation TEXT,
	summary TEXT,
	quote TEXT,
	difficulty INTEGER NOT NULL,
	role TEXT NOT NULL,
	is_favorite INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS skill (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	name TEXT NOT NULL,
	canonical_name TEXT NOT NULL,
	description TEXT NOT NULL,
	features TEXT NOT NULL,
	id_heroes NOT NULL,
	is_favorite INTEGER NOT NULL,
	FOREIGN KEY(id_heroes) REFERENCES heroes(id)
);

CREATE TABLE IF NOT EXISTS map (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    canonical_name TEXT NOT NULL,
    location TEXT,
    gamemode TEXT,
    description TEXT,
    background TEXT,
    easter_eggs TEXT,
    strategy TEXT,
    is_favorite INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS gamemode (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	name TEXT NOT NULL,
	summary TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS map_gamemode (
	id_map INTEGER NOT NULL,
	id_gamemode INTEGER NOT NULL,
	PRIMARY KEY(id_map, id_gamemode)
);
