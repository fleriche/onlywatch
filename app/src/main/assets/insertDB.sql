--Attaque
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Faucheur', 'faucheur', 0, 0, 0, 1, 'offense');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Genji', 'genji', 0, 0, 0, 3, 'offense');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('McCree', 'mccree', 0, 0, 0, 2, 'offense');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Pharah', 'pharah', 0, 0, 0, 1, 'offense');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Soldat76', 'soldat76', 0, 0, 0, 1, 'offense');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Tracer', 'tracer', 0, 0, 0, 2, 'offense');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Sombra', 'sombra', 0, 0, 0, 3, 'offense');
--Defense
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Bastion', 'bastion', 0, 0, 0, 1, 'defense');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Hanzo', 'hanzo', 0, 0, 0, 3, 'defense');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Chacal', 'chacal', 0, 0, 0, 2, 'defense');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Mei', 'mei', 0, 0, 0, 3, 'defense');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Torbjörn', 'torbjorn', 0, 0, 0, 2, 'defense');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Fatale', 'fatale', 0, 0, 0, 2, 'defense');
--Tank
INSERT INTO heroes (name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote, difficulty, role) VALUES ('D.Va', 'dva', 100, 400, 0, "Hana Song", 19, "Korean", "Competitive StarCraft player", "Busan, South Korea", "Mobile Exo-Force", "Some text", "I play to win.", 2, 'tank');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Reinhardt', 'reinhardt', 0, 0, 0, 1, 'tank');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Chopper', 'chopper', 0, 0, 0, 1, 'tank');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Winston', 'winston', 0, 0, 0, 2, 'tank');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Zarya', 'zarya', 0, 0, 0, 3, 'tank');
--Support
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Ana', 'ana', 0, 0, 0, 3, 'support');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Lúcio', 'lucio', 0, 0, 0, 2, 'support');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Ange', 'ange', 0, 0, 0, 1, 'support');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Symmetra', 'symmetra', 0, 0, 0, 2, 'support');
INSERT INTO heroes (name, canonical_name, health, armor, shield, difficulty, role) VALUES ('Zenyatta', 'zenyatta', 0, 0, 0, 3, 'support');

--skills
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Fusio-canons', 'Le méca de D.VA est équipé de canons rotatifs jumelés à courte portée. Activés, ils infligent d’importants dégâts continus sans avoir besoin d’être rechargés, mais ils ralentissent les déplacements de D.Va.', 'N/A', 14);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Pistolaser', 'Lorsqu’elle est hors de son méca, D.Va peut continuer le combat avec une arme automatique à moyenne portée.', 'N/A', 14);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Turboréacteurs', 'Le méca se projette dans les airs et D.Va est propulsée en avant par l’inertie. Elle peut tourner et changer de direction ou foncer sur ses ennemis, les projetant en arrière.', 'N/A', 14);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Matrice défensive', 'D.Va peut activer son système de ciblage avant pour abattre en l’air les projectiles qui se dirigent vers elle.', 'N/A', 14);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Autodestruction', 'D.Va s’éjecte de son méca et fait sauter son réacteur. L’explosion inflige des dégâts considérables aux adversaires proches.', 'N/A', 14);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Appel du Méca', 'Si son armure de combat blindée est détruite, D.Va peut appeler un nouveau méca et reprendre le combat.', 'N/A', 14);