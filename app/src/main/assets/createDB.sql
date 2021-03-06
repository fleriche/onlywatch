CREATE TABLE IF NOT EXISTS lang (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    locale TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS heroes (
	id INTEGER NOT NULL,
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
	is_favorite INTEGER NOT NULL,
	id_locale INTEGER NOT NULL,
	FOREIGN KEY(id_locale) REFERENCES lang(id),
    PRIMARY KEY(id, id_locale)
);

CREATE TABLE IF NOT EXISTS skill (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	name TEXT NOT NULL,
	canonical_name TEXT NOT NULL,
	description TEXT NOT NULL,
	features TEXT NOT NULL,
	id_heroes NOT NULL,
	is_favorite INTEGER NOT NULL,
	id_locale INTEGER NOT NULL,
	FOREIGN KEY(id_heroes) REFERENCES heroes(id),
	FOREIGN KEY(id_locale) REFERENCES lang(id)
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
    is_favorite INTEGER NOT NULL,
    id_locale INTEGER NOT NULL,
    FOREIGN KEY(id_locale) REFERENCES lang(id)
);