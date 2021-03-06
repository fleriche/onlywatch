--Langues
INSERT INTO lang (id, locale) VALUES (1, 'fr');
INSERT INTO lang (id, locale) VALUES (2, 'en');

------------------------------- HEROS ----------------------------------

--Attaque
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    1,
    'Faucheur',
    'faucheur',
    0,
    0,
    0,
    "Inconnue",
    0,
    "",
    "mercenaire",
    "Inconnue",
    "Inconnue",
    "",
    "La mort est parmi vous.",
    1,
    'offense',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    2,
    'Genji',
    'genji',
    0,
    0,
    0,
    "Genji Shimada",
    35,
    "",
    "aventurier",
    "monastère de Shambali, Népal",
    "clan Shimada (anciennement), Overwatch (anciennement)",
    "",
    "Même si je sacrifie mon corps, je ne sacrifierai jamais mon honneur.",
    3,
    'offense',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    3,
    'McCree',
    'mccree',
    0,
    0,
    0,
    "Jesse McCree",
    37,
    "",
    "chasseur de primes",
    "Santa Fe, Nouveau-Mexique, États-Unis",
    "Overwatch (anciennement)",
    "",
    "La justice ne va pas se rendre toute seule.",
    2,
    'offense',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    4,
    'Pharah',
    'pharah',
    0,
    0,
    0,
    "Fariha Amari",
    32,
    "",
    "responsable de la sécurité",
    "Gizeh, Égypte",
    "Helix Security International",
    "",
    "Je protégerai les innocents.",
    1,
    'offense',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    5,
    'Soldat76',
    'soldat76',
    0,
    0,
    0,
    "Inconnue",
    0,
    "",
    "justicier",
    "inconnue",
    "Overwatch (anciennement)",
    "",
    "Nous sommes tous des soldats désormais.",
    1,
    'offense',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    6,
    'Tracer',
    'tracer',
    0,
    0,
    0,
    "Lena Oxton",
    26,
    "",
    "aventurière",
    "Londres, Angleterre",
    "Overwatch (anciennement)",
    "",
    "Hello, mon chou ! La cavalerie est arrivée",
    2,
    'offense',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    7,
    'Sombra',
    'sombra',
    0,
    0,
    0,
    "Inconnue",
    30,
    "",
    "hackeuse",
    "Dorado, Mexique",
    "la Griffe, Los Muertos (anciennement)",
    "",
    "Rien ni personne n'est à l'abris du piratage.",
    3,
    'offense',
    0,
    1
);
--Defense
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    8,
    'Bastion',
    'bastion',
    0,
    0,
    0,
    "automate de siège des Laboratoires SST E54, « Bastion »",
    30,
    "",
    "automate de combat",
    "inconnue",
    "aucune",
    "",
    "",
    1,
    'defense',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    9,
    'Hanzo',
    'hanzo',
    0,
    0,
    0,
    "Hanzo Shimada",
    38,
    "",
    "mercenaire, assassin",
    "Hanamura, Japon (anciennement)",
    "clan Shimada",
    "",
    "Chaque mort est source d'honneur. L'honneur est source de rédemption.",
    3,
    'defense',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    10,
    'Chacal',
    'chacal',
    0,
    0,
    0,
    "Jamison Fawkes",
    25,
    "",
    "anarchiste, voleur, démolisseur, mercenaire, récupérateur",
    "Junkertown, Australie (anciennement)",
    "Junkers (anciennement)",
    "",
    "Une journée idéale pour foutre le boxon !",
    2,
    'defense',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    11,
    'Mei',
    'mei',
    0,
    0,
    0,
    "Mei-Ling Zhou",
    31,
    "",
    "climatologue, aventurière",
    "Xi’an, Chine (anciennement)",
    "Overwatch (anciennement)",
    "",
    "Notre monde vaut la peine qu'on se batte pour lui.",
    3,
    'defense',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    12,
    'Torbjörn',
    'torbjorn',
    0,
    0,
    0,
    "Torbjörn Lindholm",
    57,
    "",
    "fabricant d’armes",
    "Göteborg, Suède",
    "Overwatch (anciennement)",
    "",
    "Monter, démonter, c'est toujours travailler.",
    2,
    'defense',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    13,
    'Fatale',
    'fatale',
    0,
    0,
    0,
    "Amélie Lacroix",
    33,
    "",
    "assassin",
    "Annecy, France",
    "la Griffe",
    "",
    "Un tir, un mort.",
    2,
    'defense',
    0,
    1
);
--Tank
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote, difficulty, role, is_favorite, id_locale) VALUES (
    14,
    'D.Va',
    'dva',
    100,
    400,
    0,
    "Hana Song",
    19,
    "Korean",
    "joueuse pro (anciennement), pilote de méca",
    "Busan, Corée du Sud", "MEKA (Mobile Exo-force, Korean Army)",
    "",
    "Je joue pour gagner.",
    2,
    'tank',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    15,
    'Reinhardt',
    'reinhardt',
    0,
    0,
    0,
    "Reinhardt Wilhelm",
    61,
    "",
    "aventurier",
    "Stuttgart, Allemagne",
    "Overwatch (anciennement)",
    "",
    "Justice sera rendue.",
    1,
    'tank',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    16,
    'Chopper',
    'chopper',
    0,
    0,
    0,
    "Mako Rutledge",
    48,
    "",
    "tueur à gages (anciennement), garde du corps",
    "Junkertown, Australie (anciennement)",
    "Junkers (anciennement)",
    "",
    "Le motard de l'apocalypse, c'est moi",
    1,
    'tank',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    17,
    'Winston',
    'winston',
    0,
    0,
    0,
    "Winston",
    29,
    "",
    "scientifique, aventurier",
    "colonie lunaire Horizon (anciennement)",
    "Overwatch (anciennement)",
    "",
    "L'imagination est le fondement de toutes les découvertes.",
    2,
    'tank',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    18,
    'Zarya',
    'zarya',
    0,
    0,
    0,
    "Aleksandra Zaryanova",
    28,
    "",
    "soldat",
    "front de Krasnoïarsk, Russie",
    "forces de défense russes",
    "",
    "C'est l'union qui fait la force",
    3,
    'tank',
    0,
    1
);
--Support
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    19,
    'Ana',
    'ana',
    0,
    0,
    0,
    "Ana Amari",
    60,
    "",
    "chasseuse de primes",
    "Le Caire, Égypte",
    "Overwatch (anciennement)",
    "",
    "Chacun doit trouver sa cause.",
    3,
    'support',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    20,
    'Lúcio',
    'lucio',
    0,
    0,
    0,
    "Lúcio Correia dos Santos",
    26,
    "",
    "DJ, champion de la liberté",
    "Rio de Janeiro, Brésil",
    "aucune",
    "",
    "Allez, tous ensemble !",
    2,
    'support',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    21,
    'Ange',
    'ange',
    0,
    0,
    0,
    "Angela Ziegler",
    37,
    "",
    "médecin urgentiste, équipe de premiers secours",
    "Zurich, Suisse",
    "Overwatch (anciennement)",
    "",
    "Les héros ne meurent jamais.",
    1,
    'support',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    22,
    'Symmetra',
    'symmetra',
    0,
    0,
    0,
    "Satya Vaswani",
    28,
    "",
    "architecte",
    "Utopée, Inde",
    "Vishkar Corporation",
    "",
    "Le véritable ennemi de l'humanité, c'est le désordre.",
    2,
    'support',
    0,
    1
);
INSERT INTO heroes (id, name, canonical_name, health, armor, shield, real_name, age, nationality, occupation, base_of_operation, affiliation, summary, quote,  difficulty, role, is_favorite, id_locale) VALUES (
    23,
    'Zenyatta',
    'zenyatta',
    0,
    0,
    0,
    "Tekhartha Zenyatta",
    20,
    "",
    "gourou errant, aventurier",
    "monastère shambali, Népal (anciennement)",
    "les Shambali (anciennement)",
    "",
    "La vacuité est forme et la forme est vacuité.",
    3,
    'support',
    0,
    1
);

------------------------------------------ SKILLS -----------------------------------------------------------

--Skills Attaque
--Genji
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Shuriken',
    'shuriken',
    'Genji lance trois shurikens mortels en succession rapide. Il peut également lancer trois shurikens en éventail.',
    '',
    2,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Riposte',
    'riposte',
    'Avec des moulinets de son épée aussi rapides que l’éclair, Genji dévie les attaques et les renvoie vers ses adversaires.',
    '',
    2,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Frappe du vent',
    'frappeduvent',
    'Genji file en avant, tranchant l’air de son katana et traversant les ennemis sur son passage. Si Genji élimine un adversaire grâce à cette capacité, il peut s’en servir immédiatement à nouveau.',
    '',
    2,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Lame du dragon',
    'lamedudragon',
    'Genji brandit son katana pendant une courte période. Il peut délivrer des coups mortels à toutes les cibles à portée jusqu’à ce qu’il rengaine son sabre.',
    '',
    2,
    0,
    1
);
--McCree
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Pacificateur',
    'pacificateur',
    'McCree tire avec son fidèle six-coups. Il peut aussi actionner directement le chien pour vider très rapidement tout son barillet.',
    '',
    3,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Roulade',
    'roulade',
    'McCree plonge dans la direction de son déplacement et se redresse en ayant rechargé son revolver.',
    '',
    3,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Grenade Flash',
    'grenadeflash',
    'McCree jette une grenade aveuglante qui explose peu après avoir quitté sa main. La déflagration étourdit les ennemis dans un petit rayon.',
    '',
    3,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Implacable',
    'implacable',
    'Concentration. Appréciation. Prise en main. McCree prend quelques précieux instants pour viser. Quand il se décide à tirer, il abat tous les ennemis dans son champ de vision. Plus ses cibles sont faibles, moins il aura besoin de viser pour que le tir soit mortel.',
    '',
    3,
    0,
    1
);
--Pharah
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Lance-roquettes Falcon',
    'lanceroquettesfalcon',
    'Pharah utilise son arme principale pour envoyer des roquettes qui infligent des dégâts significatifs dans une large zone de déflagration.',
    '',
    4,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Réacteurs',
    'reacteurs',
    'Propulsée par les réacteurs de son armure, Pharah peut s’élever en altitude.',
    '',
    4,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Conflagration',
    'conflagration',
    'Pharah libère une roquette qui repousse violemment tous les ennemis avec lesquels elle entre en contact.',
    '',
    4,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Barrage',
    'barrage',
    'Pharah dirige une salve continue de mini-roquettes pour détruire des groupes d’ennemis.',
    '',
    4,
    0,
    1
);
--Faucheur
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Pompes funèbres',
    'pompesfunebres',
    'Faucheur met ses ennemis en pièces avec ses deux fusils à pompe.',
    '',
    1,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Forme spectrale',
    'formespectrale',
    'Faucheur devient une ombre pendant une courte période. Sous cette forme spectrale, il ne peut être blessé et il est capable de passer au travers de ses ennemis mais ne peut pas utiliser son armement ou ses autres capacités.',
    '',
    1,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Voie des ombres',
    'voiedesombres',
    'Après avoir marqué une destination de son choix, Faucheur disparaît pour réapparaître à cet endroit.',
    '',
    1,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Éclosion mortelle',
    'eclosionmortelle',
    'Quasi indiscernable, Faucheur vide ses deux fusils à pompe à tombeau ouvert, infligeant de très lourds dégâts à tous les ennemis proches.',
    '',
    1,
    0,
    1
);
--Soldat76
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Fusil à impulsions',
    'fusilaimpulsions',
    'Le fusil à impulsions entièrement automatique du soldat : 76 reste particulièrement stable lorsque ce dernier vide son chargeur.',
    '',
    5,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Roquettes LX',
    'roquetteslx',
    'Le fusil à impulsions du soldat : 76 tire plusieurs petites roquettes à la fois. L’explosion des roquettes inflige des dégâts aux ennemis dans une petite zone.',
    '',
    5,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Sprint',
    'sprint',
    'Qu’il ait besoin de fuir les tirs ennemis ou de revenir au combat rapidement, le soldat : 76 peut foncer droit devant lui. Toute action autre qu’une course vers l’avant met fin à son Sprint.',
    '',
    5,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Champ biotique',
    'champbiotique',
    'Le soldat : 76 pose au sol un émetteur biotique. L’énergie ainsi projetée soigne 76 et ses équipiers qui se trouvent dans le champ d’action.',
    '',
    5,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Visière tactique',
    'visieretactique',
    'La visière tactique de localisation du soldat : 76 « verrouille » la menace la plus proche de son viseur. Si un ennemi quitte son champ de vision, le soldat : 76 peut rapidement changer de cible.',
    '',
    5,
    0,
    1
);
--Sombra
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Pistolet mitrailleur',
    'pistoletmitrailleur',
    'Le pistolet mitrailleur automatique de Sombra tire à courte portée.',
    '',
    7,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Piratage',
    'piratage',
    'Sombra peut pirater ses ennemis et les priver temporairement de leurs capacités, ou corrompre les kits de soins pour empêcher ses adversaires de s’en servir.',
    '',
    7,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Camouflage thermoptique',
    'camouflagethermoptique',
    'Sombra devient invisible pour une courte période, pendant laquelle sa vitesse augmente considérablement. Le camouflage est désactivé si vous attaquez, si vous utilisez des capacités offensives ou si vous subissez des dégâts.',
    '',
    7,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Transducteur',
    'transducteur',
    'Sombra lance une balise de transduction vers laquelle elle peut se téléporter instantanément tant que celle-ci est active (même si la balise se trouve encore dans les airs).',
    '',
    7,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'IEM',
    'iem',
    'Sombra génère une large vague d’énergie électromagnétique qui désactive les boucliers ennemis et pirate tous les adversaires touchés par l’onde de choc.',
    '',
    7,
    0,
    1
);
--Tracer
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Pulseurs',
    'pulseurs',
    'Tracer a une cadence de tir très rapide grâce à ses pistolets.',
    '',
    6,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Transfert',
    'transfert',
    'Tracer fonce droit devant elle et réapparaît quelques mètres plus loin. Elle peut cumuler jusqu’à trois charges de transfert, et en génère régulièrement à quelques secondes d’intervalle.',
    '',
    6,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Rappel',
    'rappel',
    'Tracer bondit en arrière dans le temps et récupère les points de vie et les munitions dont elle disposait, ainsi que sa position précise sur la carte quelques secondes plus tôt.',
    '',
    6,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Bombe à impulsions',
    'bombeaimpulsions',
    'Tracer lance une grosse charge explosive qui adhère à n’importe quelle surface, ou à l’adversaire ayant le malheur de la recevoir. Après un court délai, la bombe explose en infligeant des dégâts importants à tous les ennemis dans la zone de déflagration.',
    '',
    6,
    0,
    1
);

--Skills Defense
--Bastion
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Configuration : Reconnaissance',
    'reconnaissance',
    'En mode Reconnaissance, Bastion est parfaitement mobile et équipé d’une mitrailleuse légère qui tire des rafales régulières et est efficace à moyenne portée.',
    '',
    8,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Configuration : Sentinelle',
    'sentinelle',
    'En mode Sentinelle, Bastion est une centrale électrique statique, protégée par un écran frontal et équipée d’une mitrailleuse rotative capable de déchaîner une pluie de balles. L’arme peut effectuer un « balayage » dévastateur à courte ou moyenne portée.',
    '',
    8,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Reconfiguration',
    'reconfiguration',
    'Bastion passe d’un mode de combat à l’autre afin de s’adapter aux conditions du champ de bataille.',
    '',
    8,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Autoréparation',
    'autoreparation',
    'Bastion récupère ses points de vie, mais ses systèmes d’armement sont désactivés et il reste immobile jusqu’à la fin de la réparation.',
    '',
    8,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Configuration : Tank',
    'tank',
    'En mode Tank, Bastion déploie des chenilles et un puissant canon à longue portée. Les tirs explosifs du canon démolissent les cibles présentes dans son large rayon d’explosion, mais Bastion ne peut conserver ce mode que pour un temps limité.',
    '',
    8,
    0,
    1
);
--Hanzo
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Arc tempête',
    'arctempete',
    'Hanzo encoche une flèche et la décoche sur sa cible.',
    '',
    9,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Flèche sonique',
    'flechesonique',
    'Hanzo projette une flèche équipée d’un sonar ; celle-ci marque tous les ennemis dans son rayon de détection et les rend plus faciles à traquer pour Hanzo et ses alliés.',
    '',
    9,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Mille-flèches',
    'millefleches',
    'Hanzo tire une flèche qui se fragmente en plusieurs projectiles. Ceux-ci ricochent sur les murs et les objets, et peuvent frapper plusieurs cibles.',
    '',
    9,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Frappe du dragon',
    'frappedudragon',
    'Hanzo invoque l’esprit d’un dragon qui fend les airs devant lui. Il traverse les murs sur son passage et dévore tous les ennemis rencontrés.',
    '',
    9,
    0,
    1
);
--Chacal
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Lance-grenades',
    'lancegrenades',
    'Le lance-grenades de Chacal projette des grenades sur une bonne distance. Elles rebondissent pour atteindre leur destination et explosent quand elles frappent un ennem',
    '',
    10,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Mine incapacitante',
    'mineincapacitante',
    'Après avoir placé une de ses mines incapacitantes maison, Chacal peut la déclencher pour blesser les ennemis et les faire voler dans les airs... ou se propulser lui-même en l’air.',
    '',
    10,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Piège d''acier',
    'piegedacier',
    'Chacal balance un piège géant à mâchoire métallique. Si un ennemi s’approche trop près du piège, il se referme, l’immobilisant et le blessant.',
    '',
    10,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Mauvais perdant',
    'mauvaisperdant',
    'Le sens de l''humour complètement azimuté de Chacal subsiste après sa mort : s’il est tué, il largue plusieurs grenades dégoupillées.',
    '',
    10,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Pneumastic',
    'pneumastic',
    'Chacal fait vrombir une bombe-pneu motorisée qui peut grimper sur les murs et les obstacles, et l’envoie rouler sur le champ de bataille. Il peut faire détoner le pneumastic à distance pour infliger d''importants dégâts aux ennemis pris dans l’explosion, ou simplement attendre qu’il explose de lui-même.',
    '',
    10,
    0,
    1
);
--Mei
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Canon endothermique',
    'canonendothermique',
    'Le blaster de Mei libère un flux de givre concentré à courte portée qui endommage, ralentit et finit par geler sur place les ennemis. Mei peut aussi s’en servir pour tirer des glaçons à portée moyenne.',
    '',
    11,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Cryostase',
    'cryostase',
    'Mei s’entoure instantanément d''un épais bloc de glace. Elle se soigne et échappe aux dégâts tant qu’elle est à l’intérieur, mais elle ne peut ni se déplacer, ni utiliser de capacités.',
    '',
    11,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Mur de glace',
    'murdeglace',
    'Mei génère un énorme mur de glace qui bouche les lignes de vue, empêche le déplacement et bloque les attaques.',
    '',
    11,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Blizzard',
    'blizzard',
    'Mei déploie un drone de modification du climat qui émet des bourrasques de vent et de neige dans une large zone. Les ennemis pris dans le blizzard sont ralentis et subissent des dégâts, et ceux qui s’attardent trop longtemps sont complètement gelés.',
    '',
    11,
    0,
    1
);
--Torbjörn
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Pistolet à rivets',
    'pistoletarivets',
    'Avec son pistolet, Torbjörn tire des rivets à longue portée ou des projectiles de métal surchauffé en petites rafales à courte portée.',
    '',
    12,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Marteau de forge',
    'marteaudeforge',
    'Torbjörn utilise son marteau polyvalent pour construire, améliorer et réparer des tourelles, et peut l’utiliser comme arme en cas d’urgence.',
    '',
    12,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Déploiement de tourelle',
    'deploiementdetourelle',
    'Torbjörn construit un canon automatique avec un système de suivi des ennemis. Il peut utiliser la ferraille récupérée sur les ennemis ou alliés abattus pour l’améliorer, augmentant ses points de vie et y ajoutant un second canon et un lance-roquettes.',
    '',
    12,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Module d''armure',
    'moduledarmure',
    'Torbjörn fabrique des pièces d’armure que lui-même ou ses alliés peuvent ramasser pour absorber une partie des dégâts.',
    '',
    12,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Coeur de magma',
    'coeurdemagma',
    'Déclencher la surchauffe de sa forge personnelle permet à Torbjörn de gagner une quantité significative d’armure et de ferraille, mais aussi d’attaquer (et de construire ou de réparer des tourelles) bien plus rapidement qu’en temps normal.',
    '',
    12,
    0,
    1
);
--Fatale
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Baiser de la veuve',
    'baiserdelaveuve',
    'Fatale est équipée d’un fusil polyvalent idéal pour abattre à la lunette les cibles les plus lointaines. Il peut aussi être utilisé en mode automatique sur les cibles à moyenne portée.',
    '',
    13,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Grappin',
    'grappin',
    'Fatale peut envoyer un grappin vers la position qu’elle vise. Une fois le grappin arrimé, elle est rapidement attirée le long de son câble, ce qui lui permet d’améliorer sa visibilité du champ de bataille et d’esquiver ou de contourner des cibles.',
    '',
    13,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Mine venimeuse',
    'minevenimeuse',
    'Fatale applique des mines venimeuses à armement rapide qui adhèrent à quasiment n’importe quelle surface. Lorsqu’une cible s’aventure à portée du détecteur de mouvement intégré à la mine, cette dernière explose en dégageant un gaz empoisonné qui affecte tous les ennemis à proximité.',
    '',
    13,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Infravision',
    'infravision',
    'La visière de reconnaissance de Fatale lui permet de voir la signature thermique de ses cibles, même au travers des murs ou autres obstacles pendant un certain temps. Cette perception améliorée est partagée avec ses alliés.',
    '',
    13,
    0,
    1
);

--Skills Tank
--D.va
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Fusio-canons',
    'fusiocanons',
    'Le méca de D.VA est équipé de canons rotatifs jumelés à courte portée. Activés, ils infligent d’importants dégâts continus sans avoir besoin d’être rechargés, mais ils ralentissent les déplacements de D.Va.',
    'N/A',
    14,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Pistolaser',
    'pistolaser',
    'Lorsqu’elle est hors de son méca, D.Va peut continuer le combat avec une arme automatique à moyenne portée.',
    'N/A',
    14,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Turboréacteurs',
    'turboreacteurs',
    'Le méca se projette dans les airs et D.Va est propulsée en avant par l’inertie. Elle peut tourner et changer de direction ou foncer sur ses ennemis, les projetant en arrière.',
    'N/A',
    14,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Matrice défensive',
    'matricedefensive',
    'D.Va peut activer son système de ciblage avant pour abattre en l’air les projectiles qui se dirigent vers elle.',
    'N/A',
    14,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Autodestruction',
    'autodestruction',
    'D.Va s’éjecte de son méca et fait sauter son réacteur. L’explosion inflige des dégâts considérables aux adversaires proches.',
    'N/A',
    14,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Appel du Méca',
    'appeldumeca',
    'Si son armure de combat blindée est détruite, D.Va peut appeler un nouveau méca et reprendre le combat.',
    'N/A',
    14,
    0,
    1
);
--Reinhardt
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Marteau à réaction',
    'marteauareaction',
    'Le marteau à réaction de Reinhardt est une arme de combat rapproché exemplaire, capable d’infliger des dégâts brutaux sur un large arc à chaque coup.',
    '',
    15,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Écran',
    'ecran',
    'Reinhardt déploie devant lui un large écran énergétique qui peut absorber une grande quantité de dégâts avant de disparaître. Reinhardt peut se protéger ainsi que ses compagnons qui se trouvent derrière l’écran, mais il ne peut pas attaquer pendant qu’il le maintient en place.',
    '',
    15,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Charge',
    'charge',
    'Reinhardt charge droit devant lui et saisit le premier ennemi qui se trouve sur son chemin. S’il entre en collision avec un mur, les adversaires qu’il porte sont écrasés et subissent des dégâts extrêmes.',
    '',
    15,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Frappe de feu',
    'frappedefeu',
    'En faisant tournoyer son marteau devant lui, Reinhardt envoie un projectile enflammé qui transperce et inflige des dégâts à tous les ennemis qu’il touche.',
    '',
    15,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Choc sismique',
    'chocsismique',
    'Reinhardt abat son marteau à réaction sur le sol, ce qui blesse et renverse tous les ennemis devant lui',
    '',
    15,
    0,
    1
);
--Chopper
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Déferrailleur',
    'deferailleur',
    'Le déferrailleur de Chopper lance du shrapnel à courte portée mais sur une large zone. Sinon il peut lancer une boule de shrapnels qui détone plus loin, éparpillant les fragments métalliques depuis le point d’impact.',
    '',
    16,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Inhalateur',
    'inhalateur',
    'Chopper récupère une partie de ses points de vie sur une courte période.',
    '',
    16,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Traquelard',
    'traquelard',
    'Chopper lance sa chaîne vers une cible ; s’il l’attrape, il l’attire à lui, à courte portée.',
    '',
    16,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Équarisseur',
    'equarisseur',
    'Après avoir ajouté un chargeur supplémentaire au-dessus de son déferrailleur, Chopper le bourre de munitions. Pendant une courte période, il mitraille une large zone devant lui avec des shrapnels qui repoussent les ennemis.',
    '',
    16,
    0,
    1
);
--Winston
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Canon Tesla',
    'canontesla',
    'Tant que Winston garde le doigt sur la gâchette, son arme envoie un flot de décharges électriques à courte portée.',
    '',
    17,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Propulseurs',
    'propulseurs',
    'Winston bondit dans les airs avec l’aide de sa réserve d’énergie dorsale et retombe en infligeant des dégâts significatifs et en étourdissant les ennemis proches.',
    '',
    17,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Générateur d''écran',
    'generateurdecran',
    'Le générateur d’écran de Winston projette un champ de force en forme de bulle qui absorbe les dégâts jusqu’à sa destruction. Les alliés à l’intérieur sont protégés et peuvent tirer.',
    '',
    17,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Rage primordiale',
    'rageprimordiale',
    'Winston embrasse sa nature animale, augmentant notablement ses points de vie et le rendant très difficile à tuer, renforçant ses attaques en mêlée et lui permettant d’utiliser ses propulseurs plus souvent. Quand il est enragé, Winston ne peut utiliser que les propulseurs et les attaques au corps à corps.',
    '',
    17,
    0,
    1
);
--Zarya
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Canon à particules',
    'canonaparticules',
    'Le puissant canon à particules de Zarya déchaîne un rayon d’énergie destructrice à courte portée. Zarya peut également s’en servir pour projeter une charge explosive capable de blesser plusieurs adversaires.',
    '',
    18,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Écran de particules',
    'ecrandeparticules',
    'Le canon à particules peut émettre une barrière individuelle qui protège Zarya contre les attaques la ciblant, absorbant leur énergie pour augmenter les dégâts et la largeur du rayon de son arme.',
    '',
    18,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Écran généré',
    'ecrangenere',
    'Zarya englobe l’un de ses coéquipiers dans une barrière d’énergie qui absorbe les coups et renforce la puissance de son canon à particules.',
    '',
    18,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Orbe à gravitons',
    'orbeagravitons',
    'Zarya lance une bombe gravitationnelle qui attire les combattants ennemis et les blesse tant qu’ils restent piégés.',
    '',
    18,
    0,
    1
);

--Skills Support
--Ana
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Fusil biotique',
    'fusilbiotique',
    'Le fusil d’Ana projette des fléchettes qui régénèrent les points de vie de ses alliés ou infligent des dégâts continus à ses ennemis. La lunette de son fusil lui permet de zoomer sur ses cibles pour des tirs d’une extrême précision.',
    '',
    19,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Fléchette hypodermique',
    'flechettehypodermique',
    'Ana tire une fléchette avec son arme de poing, provoquant l’évanouissement d’un ennemi (qui se réveille s’il subit des dégâts)',
    '',
    19,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Grenade biotique',
    'grenadebiotique',
    'Ana lance une bombe biotique qui inflige des dégâts aux ennemis et soigne les alliés dans une zone de taille réduite. Pendant un court moment, les alliés affectés reçoivent plus de soins de toutes les sources, tandis que les ennemis pris dans l’explosion ne peuvent temporairement plus être soignés.',
    '',
    19,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Nanoboost',
    'nanoboost',
    'Lorsqu’ils reçoivent un bonus de combat de la part d’Ana, ses alliés se déplacent temporairement plus vite, infligent plus de dégâts et résistent mieux aux attaques ennemies.',
    '',
    19,
    0,
    1
);
--Lúcio
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Ampli',
    'ampli',
    'Lúcio peut frapper ses ennemis à l’aide de projectiles soniques ou les repousser avec une onde de choc sonore.',
    '',
    20,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Crossfade',
    'crossfade',
    'Lúcio se stimule constamment, ainsi que ses équipiers proches, grâce à la musique. Il peut alterner entre deux chansons : l’une augmente la vitesse de déplacement, la seconde rend des points de vie.',
    '',
    20,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Volume max.',
    'volumemax',
    'Lúcio augmente le volume de ses enceintes, ce qui améliore l’effet de ses chansons.',
    '',
    20,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Mur de son',
    'murdeson',
    'Des vagues protectrices irradient de l’ampli de Lúcio et lui procurent ainsi qu’à ses alliés proches des boucliers personnels.',
    '',
    20,
    0,
    1
);
--Ange
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Caducée',
    'caducee',
    'Ange projette un des deux rayons sur un allié. En maintenant les rayons, elle peut soigner l’allié ciblé ou augmenter les dégâts qu’il inflige.',
    '',
    21,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Miséricorde',
    'misericorde',
    'Ange peut tirer avec cette arme de poing, qu’il vaut mieux conserver pour sa protection personnelle.',
    '',
    21,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Ange gardien',
    'angegardien',
    'Ange vole vers un allié ciblé. Elle peut ainsi rejoindre rapidement ses coéquipiers pour mieux les assister dans les moments cruciaux.',
    '',
    21,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Saut de l''ange',
    'sautdelange',
    'Grâce aux propulseurs de son armure Valkyrie, Ange peut ralentir sa vitesse de chute et descendre de n’importe quelle hauteur.',
    '',
    21,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Résurrection',
    'resurrection',
    'Ange irradie de puissance restauratrice et ranime les alliés morts autour d’elle avec la totalité de leurs points de vie.',
    '',
    21,
    0,
    1
);
--Symmetra
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Projecteur à photons',
    'projecteuraphotons',
    'L’arme de Symmetra émet un rayon à courte portée qui se focalise sur un ennemi proche, lui infligeant des dégâts continus qui augmentent sur la durée. Le projecteur peut aussi envoyer une boule d’énergie surchargée qui inflige des dégâts importants.',
    '',
    22,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Tourelle sentinelle',
    'tourellesentinelle',
    'Symmetra installe une petite tourelle qui projette automatiquement des décharges réduisant la vitesse de l’ennemi le plus proche à sa portée. Plusieurs tourelles peuvent être déployées simultanément sur le champ de bataille.',
    '',
    22,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Bouclier à photons',
    'bouclieraphotons',
    'Symmetra enveloppe un allié dans un bouclier photoformé qui absorbe les dégâts et subsiste aussi longtemps que l’allié reste en vie.',
    '',
    22,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Téléporteur',
    'teleporteur',
    'Symmetra place un socle d’arrivée à sa position actuelle et le connecte à celui placé au point de départ de son équipe. Les alliés peuvent voyager instantanément d’un socle à l’autre, ce qui leur permet de retourner rapidement au combat après avoir été abattus.',
    '',
    22,
    0,
    1
);
--Zenyatta
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Orbe de destruction',
    'orbededestruction',
    'Zenyatta lance ses orbes d’énergie destructrice soit individuellement, soit en rafale après avoir passé quelques secondes à rassembler de l’énergie.',
    '',
    23,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Orbe d''harmonie',
    'orbedharmonie',
    'Zenyatta lance un orbe au-dessus d’un allié ciblé. Tant que Zenyatta reste en vie, l’orbe restaure lentement les points de vie de cet allié. Ne peut être utilisé que sur un allié à la fois.',
    '',
    23,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Orbe de discorde',
    'orbedediscorde',
    'Lancer un orbe de discorde sur un ennemi amplifie la quantité de dégâts que celui-ci reçoit tant que Zenyatta est en vie. Ne peut être utilisé que sur un adversaire à la fois.',
    '',
    23,
    0,
    1
);
INSERT INTO skill (name, canonical_name, description, features, id_heroes, is_favorite, id_locale) VALUES (
    'Transcendance',
    'transcendance',
    'Zenyatta parvient à accéder à un stade d’existence supérieur pendant un court moment. Tant qu’il se transcende, Zenyatta ne peut pas utiliser ses capacités ou ses armes, mais il est immunisé aux dégâts et restaure automatiquement ses points de vie et ceux des alliés proches.',
    '',
    23,
    0,
    1
);

----------------------------------- MAPS ------------------------------------------------

--Maps
INSERT INTO map (name, canonical_name, location, gamemode, description, background, easter_eggs, strategy, is_favorite, id_locale) VALUES (
    'Dorado',
    'dorado',
    'Mexico',
    'Control',
    'Dorado is one of the locations in Overwatch. It is an Escort map. It is Festival de la Luz in Dorado, an annual celebration of the end of the Omnic Crisis and the period of darkness - both figurative and literal - that engulfed Mexico when the Omnics destroyed much of the country''s power grid and infrastructure. But there is a new dawn, as LumériCo and its CEO, war hero and former president Guillermo Portero, are unveiling a string of fusion plants that promise to deliver clean, free energy to the Mexican people. The payload in this map is a truck with a fusion core in the back. The attacking team must escort it to the ziggurat to activate the power plant.',
    'During the Omnic Crisis, Mexico''s infrastructure was destroyed in what its people call ''La Medianoche'', causing the nation to lose power and internet access for years. Today, the citizens of Dorado celebrate its end with the Festival de la Luz. LumériCo was founded by former president Guillermo Portero to repair the network, but a gang called Los Muertos has been fighting the company and accusing it of being corrupt. In Hero, Soldier: 76 traveled to Dorado and had a firefight with Los Muertos members. In the process, he saved Alejandra, a preteen girl whose family runs the Panadería las Nieblas by the cliffside. LumériCo''s latest power plant in Dorado was set to be finished on November 1, with a large party on Market Street to celebrate it. However, Los Muertos managed to hack into LumériCo''s database with help from a ''hacker collective'' called Sombra. They leaked emails exposing the company''s financial scandals and connections to Vishkar, sparking protests on the day of the celebration. On the same day, Junkrat and Roadhog broke into the Banco de Dorado and stole millions of dollars in gold. Two days later, Guillermo Portero stepped down from his position as CEO, and pro-Sombra graffiti has appeared across the world.',
    '<ul><li>In the market, there is a piñata that resembles Diablo from the franchise of the same name.</li></br><li>To the left of the second attackers'' spawn, there is Los Muertos graffiti identical to the graffiti in Hollywood.</li></br><li>In front of the town hall, there is a statue of Guillermo Portero, with a plaque that says "Presidente Guillermo Portero - Protector de México".</li></br><li>Near the final defenders'' spawn, there is a table with three folders on it, all marked "Clasificado". One is marked "Jack Morrison", another says "Soldado: 76", and the last says "Sombra".</li></br><li>In the final defenders'' spawn, there is a map of Mexico marked "Estado de Red Eléctrica". Several towns are marked, including Dorado.</li></br></ul>',
    '',
    0,
    1
);
INSERT INTO map (name, canonical_name, location, gamemode, description, background, easter_eggs, strategy, is_favorite, id_locale) VALUES (
    'Gibraltar',
    'gibraltar',
    'The rock of Gibraltar',
    'Escort',
    'Watchpoint: Gibraltar is one of the locations in Overwatch. It is an Escort map. At its height, Overwatch maintained numerous bases around the world, each with its own purpose: peacekeeping, scientific research, or in the case of Watchpoint: Gibraltar, providing an orbital launch facility. The base was mothballed along with the rest of Overwatch''s installations, but there have been recent reports of activity within the perimeter. Could this indicate the presence of former Overwatch agents, or is this the work of organizations with more nefarious intentions? The payload on this map is a satellite drone. The attacking team must escort it to the launch gantry to send it into orbit.',
    'The Rock of Gibraltar is a promontory located on the southern coast of the Iberian Peninsula. Roughly 40% of its land area is a nature reserve. During its golden age, Overwatch established a Watchpoint in the Rock of Gibraltar for use as an orbital launch facility. After its collapse, Watchpoint: Gibraltar was shut down by mandate of the Petras Act. Winston and Athena continued to inhabit the watchpoint long afterwards. In the event that the Overwatch agents would need to be recalled, Winston sent a satellite drone into orbit to send a message when activated. In Recall, Reaper and a group of Talon agents attacked the Watchpoint and attempted to hack into its computers. Winston was able to fight them off, and afterwards sent out the recall signal, re-establishing connections with Overwatch''s agents.',
    '<ul><li>In Winston''s lab, there is a blackboard that says "Winston''s to-do list! - Step 1: Move satellite drone to launch platform! - Step 2: Launch drone into synchronous orbit - Step 3: Triangulate global "Recall" signal - Step 4: Call Overwatch agents back to active duty!!! - Order more peanut butter..."</li></br><li>Before the March 8, 2016 patch, a few monitors displayed messages from Athena trying to contact Winston. After the patch, they now display Athena''s logo. The patch also added a large hole in the window within Winston''s lab. This was made to match with the animated short, Recall.</li></br><li>Winston''s lab has a chart depicting the map and the route the payload takes.</li></br><li>Within the crew quarters are a set of lockers, each with a name stenciled along their bottom: Bowden, Sparks, Pinto, Rogers, Klevstav, Klimas, and Eulaers. Some of these are direct nods to the environment team for Overwatch: Helder Pinto, Dion Rogers, Philip Klevestav, Andrew Klimas, and Bram Eulaers. Lee Sparks is the Senior Game Producer.</li></br><li>A poster of Genji is above one of the beds.</li></br><li>The shuttle in the hangar is marked "Lt. Maria Estrada" and "Aurora OSS-7".</li></br></ul>',
    '',
    0,
    1
);
INSERT INTO map (name, canonical_name, location, gamemode, description, background, easter_eggs, strategy, is_favorite, id_locale) VALUES (
    'Hollywood',
    'hollywood',
    'Los Angeles, California',
    'Hybrid',
    'Hollywood is one of the locations in Overwatch. It is a Hybrid map. Welcome to the glitz and glamour of Hollywood, California, where palm trees and fancy cars line the streets, and movie stars, directors, and high-powered studio executives rub shoulders for a chat and drink at Galand''s. Down the street from the Mandarin Theatre, Goldshire Studios'' omnic film auteur Hal-Fred Glitchbot has created his two latest films, They Came From Beyond The Moon and Six-Gun Killer, to varying amounts of critical and commercial acclaim. However, even Tinseltown has been gripped by anti-omnic sentiment, and the outspoken director has become a prime target in the escalating conflict. The payload on this map is Hal-Fred Glitchbot''s limousine. The attacking team must escort him to his trailer.',
    'Hollywood is a neighborhood in Los Angeles, California. Since 1912, it has been the center of the USA''s film industry. Since he began making movies with Goldshire Pictures, director Hal-Fred Glitchbot has been the target of anti-omnic protesters. With the upcoming release of his two latest films They Came From Beyond The Moon and Six-Gun Killer, Glitchbot is running low on funding.',
    '<ul><li>Around the first attacking spawn point there are several movie posters for They Came From Beyond The Moon, Six Gun Killer, Some Like It Bot, and Hero Of My Storm.</li></br><li>Two billboards advertising Lúcio can be seen between the first attacker spawn and the control point.</li></br><li>The Walk of Fame features the names of several actors, including Maifie Adams, Baleog Fierce, Olivia Rai, Olaf Stout, Samuel Drest, Erik Swift, Robert Greenways, Sakura Cheong, and Thespion 4.0.</li></br><li>Baleog the Fierce, Olaf the Stout and Erik the Swift are the main characters from the game ''The Lost Vikings''.</li></br><li>Despite Hollywood being in the United States, the Babylon Hotel''s cash register has a pound sign (£) on it.</li></br><li>Down the road to the left of the attackers'' spawn, there is Los Muertos graffiti identical to the graffiti in Dorado.</li></br><li>In the security room by the first point, a monitor can be seen with a game of Hearthstone open.</li></br><li>At the final point, there is a Tyrael-brand trailer.</li></br><li>Hal-Fred Glitchbot''s voice line "Jesse Mccree? That''s a terrible name for a cowboy." is a reference to the 2000 film Shanghai Noon.</li></br></ul>',
    '',
    0,
    1
);
INSERT INTO map (name, canonical_name, location, gamemode, description, background, easter_eggs, strategy, is_favorite, id_locale) VALUES (
    'King''s Row',
    'kingsrow',
    'London, England',
    'Hybrid',
    'King''s Row is one of the locations in Overwatch. It is a Hybrid map. King''s Row is an upscale, cosmopolitan neighborhood of London, but just beneath its peaceful surface, tensions between omnics and humans are running high. While much of modern England was built on the backs of omnic laborers, they have been denied the basic rights that humans have, with most omnics forced to live in the dense, claustrophobic city beneath the city, known by some as "the Underworld". Of greater concern is that recent demonstrations by pro-omnic rights protesters have resulted in violent clashes with the police, and a solution is nowhere in sight. The payload on this map is a large EMP bomb. The attacking team must escort it to the Underworld, detonating it.',
    'Omnic workers were responsible for rebuilding England after the Omnic Crisis. England, however, does not recognize their rights, and in the London neighborhood of King''s Row, omnics are forced to live beneath the surface in ''the Underworld''. Since Overwatch''s collapse, omnic rights protests have risen to prominence. Tekhartha Mondatta was at the forefront of the movement, preaching equality throughout the city. In Alive, Tekhartha Mondatta was assassinated during a speech in front of the Meridian by Widowmaker. Since then, protests have grown increasingly violent throughout the city.',
    '<ul><li>In the first attackers'' spawn, there are a few tablets with Hearthstone on them, as well as several Kofi Aromo cups.</li></br><li>In the first defenders'' spawn, there is a poster for Lúcio''s concerts.</li></br><li>In front of The Meridian, there is a photo of Tekhartha Mondatta with several candles around it.</li></br><li>The clock tower at the control point, presumably a rendition of the Elizabeth Tower, shows that the in-game time is 4:00 AM.</li></br></ul>',
    '',
    0,
    1
);
INSERT INTO map (name, canonical_name, location, gamemode, description, background, easter_eggs, strategy, is_favorite, id_locale) VALUES (
    'Numbani',
    'numbani',
    'Nigerian savanna',
    'Hybrid',
    'Numbani is one of the locations in Overwatch. It is a Hybrid map. Known as the "City of Harmony", Numbani is one of the few places where omnics and humans live as equals. This collaboration has led to the creation of one of the world''s greatest and most technologically advanced cities in the short time since its establishment after the end of the Omnic Crisis. As part of this year''s Unity Day festivities celebrating the city''s founding, the gauntlet of the infamous Doomfist is being exhibited at the Numbani Heritage Museum. The payload in this map is a carrier containing Doomfist''s gauntlet. The attacking team must escort it to the Numbani Heritage Museum.',
    'Built shortly after the Omnic Crisis, Numbani is one of few cities where omnics and humans have the same rights. The collaboration has made the city one of the world''s most technologically advanced, and every year they celebrate its founding with Unity Day. For this year''s Unity Day, the Numbani Heritage Museum has opened an exhibit on Doomfist, featuring the villain''s gauntlet. However, the Unity Day festival has been postponed due to anonymous threats.',
    '<ul><li>In the Adawe International Airport, there are posters for Hanamura, Temple of Anubis, King''s Row, and Russia (with a picture of Volskaya Industries). The same posters can be seen in Numbani Tours International.</li></br><li>The Arrivals screen in the Adawe International Airport has the following cities: Seoul, Moscow, Cork, Hong Kong, Buenos Aires, Rome, Madrid, Paris, Hanamura, Delhi, Shanghai, Frankfurt, Singapore, Austin, Dorado, New York, San Francisco, Taipei, Johannesburg, Sydney, King''s Row, Versailles, Los Angeles, and Irvine.</li></br><li>Several posters for Lúcio''s concerts can be seen around the city.</li></br><li>Throughout the map, there is a poster for a beverage called Old Glenwales. It says "Relax and Unwind - The Legendary Organic Oil - 2030". On it is an omnic holding a glass of the drink.</li></br><li>The Axiom building has an Atlas News ticker and a stock market ticker:</li></br><ul><li>"LumériCo reports breach at Dorado power plant, latest attack in global hacking spree"</li></br><li>"Volskaya Ind. increases production following Siberian Omnium attacks"</li></br><li>SST 0.39 ↓ -0.21 · IZU 9.74 ↓ -0.38 · AXOM 364.40 ↑ +29.15 · VLSK 26.85 ↓ -2.69 · VISH 61.41 ↑ +4.56</li></br></ul></ul>',
    '',
    0,
    1
);
INSERT INTO map (name, canonical_name, location, gamemode, description, background, easter_eggs, strategy, is_favorite, id_locale) VALUES (
    'Route 66',
    'route66',
    'Route 66, US Southwest',
    'Escort',
    'Route 66 is one of the locations in Overwatch. It is an Escort map. Though the travelers and road trippers who used to cross the US on historic Route 66 are gone, the Main Street of America still stands, a testament to a simpler time. The gas stations, roadside shops, and cafes have gone into disuse, and the fabled Deadlock Gorge is mostly seen from the comfort of transcontinental train cars. But amid the fading monuments of that earlier era, the outlaws of the Deadlock Gang are planning their biggest heist yet. The payload on this map is a carrier for a US military bomb. The attacking team must escort it to the Deadlock Gang''s cave hideout.',
    'U.S. Route 66 was a highway that ran through the American Southwest from Santa Monica, CA to Chicago, IL. Since the Interstate Highway System was introduced, the route was officially decommissioned in 1985. The establishments around the route have fallen into disuse with the introduction of transcontinental hypertrains. One segment of the highway, the Deadlock Gorge, has been completely abandoned by law-abiding citizens, leaving only the Deadlock Gang, which took advantage of the solitude for illicit weapons trafficking. During its golden age, Overwatch took on the challenge of dismantling the gang. Gabriel Reyes led a Blackwatch sting operation in the gorge, capturing several gang members, including Jesse McCree. Reyes saw potential in McCree and allowed him to join Blackwatch to turn a new leaf - the remaining Deadlock members still resent him for this. Recently, the Deadlock Gang has pulled off their biggest heist. They used explosives to blow up a bridge above the gorge, leaving destroyed U.S. military traincars scattered around the Panorama Diner. From the train, they have stolen a large bomb.',
    '<ul><li>The Panorama Diner is filled with references to Blizzard''s other games:</li></br><li><ul><li>A check signed by Deckard Cain is hung on the wall.</li></br><li>Several "Craft from the Stars" comics are lying on tables.</li></br><li>The second attackers'' spawn is a tourist trap called the Cave of Mystery, using Hal-Fred Glitchbot''s movie They Came From Beyond The Moon as a theme.</li></br></ul></li></br><li>In The High Side, there are several Hearthstone playing cards.</li></br><li>The first defenders'' spawn is Deadlock Propane and Propane Accessories, references the Texas-based animated show King of the Hill and propane enthusiast main character Hank Hill''s job.</li></br><li>In the cave, there are crates marked with the logos of various companies, including Lumérico, Kofi Aromo, Adams Instant Chicken and Rice, Lucheng Interstellar, Rikimaru, and Salt-Flavored Potato Chips.</li></br><li>In the final defenders'' spawn, there is a computer with Hearthstone open.</li></br></ul>',
    '',
    0,
    1
);
INSERT INTO map (name, canonical_name, location, gamemode, description, background, easter_eggs, strategy, is_favorite, id_locale) VALUES (
    'Hanamura',
    'hanamura',
    'Japan',
    'Assault',
    'Hanamura is one of the locations in Overwatch. It is an Assault map. Hanamura is a well-preserved village of unassuming shops and quiet streets known mostly for its idyllic cherry blossom festival every spring. But to those who know its history, Hanamura is the ancestral home of the Shimada ninja clan, which had grown over the centuries to become a powerful criminal organization. As its neighboring cities expanded, Hanamura was encircled, and eventually, it was incorporated as a district within a larger city. For now, the imposing compound of the Shimada family lies empty, but that peace may soon be broken.',
    'Hanamura was the home of the Shimada Empire, and of Hanzo and Genji by extension. While Hanzo was trained in martial arts, archery, and sword fighting in the dojo, Genji had the freedom to enjoy the ramen shops and arcades of the modern districts surrounding the Shimada compound. After Hanzo was named heir, he fought and nearly killed Genji. Though Genji was saved by Overwatch, Hanzo was unaware, and left his sword in Hanamura out of shame. The Shimada Empire was later dismantled by Overwatch, and the town became the site of an annual cherry blossom festival. Hanzo returned to the dojo every year to honor Genji. At some point, McCree visited Hanamura and stopped a robbery at the local Rikimaru. In Dragons, Genji returned to Hanamura to meet Hanzo for the first time since he was nearly killed. Hanzo thought Genji was just another assassin, but after Genji came out on top of a fight, he revealed himself and forgave Hanzo for what he had done.',
    '<ul><li>Above Rikimaru there is a statue of a murloc in a spaceship, eating noodles. If the murloc is shot, it makes the familiar aggro sound from World of Warcraft.</li></br><li>In the arcade, there is a large poster of D.Va on the wall.</li></br><li>The arcade has several games :</li></br><ul><li>Claw games whose glass can be destroyed, freeing the squeaky toys within</li></br><li>Fighters of the Storm: clearly an homage to Heroes of the Storm and 2D fighting games such as Street Fighter. This game shows Tychus and Tyrael facing each other in combat.</li></br><li>Fighters of the Storm 2: along the same vein, this one has Garrosh Hellscream and Kerrigan squaring off. As of the Overwatch beta, Garrosh had not been introduced into Heroes of the Storm.</li></br><li>Vivi''s Adventure: this game features a small cavegirl similar to Pebbles on the Flintstones; this could be a reference to Li Li, an adventurous pandaren within World of Warcraft.</li></br><li>The Lost Vikings VI: A futuristic homage to Blizzard''s The Lost Vikings. It appears to be a top down scrolling shoot ''em up in the same vein as Galaga. It also features a Viking unit used in StarCraft II.</li></br><li>Super Siege Mode 3: a game that pays homage to the Metal Slug series. It appears to have Raynor and Sergeant Hammer as characters. A Vulture unit from StarCraft can also be seen driving across the screen periodically.</li></br><li>Holobloks: A 3D version of Breakout that can support two players.</li></br><li>Soulstone: Demon-Slayer: potentially a reference to soulstones used by warlocks in World of Warcraft; also possibly a reference to soulstones in Diablo III: Reaper of Souls, or the Soul Calibur series. The game resembles Capcom''s Dungeons & Dragons arcade series.</li></br></ul><li>The mural above the last point currently depicts two dragons, one green and one blue, circling each other, referencing the story in the animated short, Dragons. It used to depict a dragon, an archer dressed in blue, and a swordsman dressed in green.</li></br></ul>',
    '',
    0,
    1
);
INSERT INTO map (name, canonical_name, location, gamemode, description, background, easter_eggs, strategy, is_favorite, id_locale) VALUES (
    'Temple d''Anubis',
    'templedanubis',
    'Giza, Egypt',
    'Assault',
    'Temple of Anubis is one of the locations in Overwatch. It is an Assault map. Nestled among the ancient ruins of the Giza Plateau on the outskirts of Cairo, the Temple of Anubis is one of many new excavations in the area. While most believe that the site is of interest for archaeological reasons, it also hides the entrance to a research facility that extends deep beneath the earth. The facility is alleged to house an artificial intelligence, but the whole truth is known only to a select few. Not even the agents of Helix Security International, who guard the facility, know what they''re protecting.',
    'During the Omnic Crisis, Overwatch''s original strike team quarantined a God Program called Anubis in a research facility beneath the Giza Plateau. Its existence was never made public, and a team of Helix Security International guards was assigned to guard it. In Mission Statement, Anubis briefly broke free and began to take control of omnics in the area. Before it could breach Helix''s firewalls, it was defeated by a team led by Pharah.',
    '<ul><li>In the attackers'' first spawn, there is a tablet with Hearthstone open propped up in front of a folder with a photograph of Ana''s Shrike skin.</li></br><li>A Zerg hydralisk skull is mounted on the wall of the vehicle in which attackers spawn at the beginning of the match.</li></br><li>The attackers'' spawn vehicle has a murloc spraypainted on the side.</li></br><li>If a player hits the murloc''s eye, it will make a noise.</li></br><li>Many hieroglyphs have the symbol of the Horde mixed in with them.</li></br></ul>',
    '',
    0,
    1
);
INSERT INTO map (name, canonical_name, location, gamemode, description, background, easter_eggs, strategy, is_favorite, id_locale) VALUES (
    'Usine Volskaya',
    'usinevolskaya',
    'near St. Petersburg, Russia',
    'Assault',
    'Volskaya Industries is one of the locations in Overwatch. It is an Assault map. Russia was one of the countries hit hardest by the Omnic Crisis, but during the rebuilding progress, it rode the wave of the mechanized labor industry''s revitalization and entered a period of rapid growth. However, after recent attacks from the long-dormant Siberian Omnium, Russia has returned to war footing, guarding its sparkling cities with the massive human-piloted Svyatogor mechs developed and produced by Volskaya Industries.',
    'Russia was one of the first countries to be affected by the Omnic Crisis. Having no help from Overwatch, Russia was forced to combat the omnic forces alone. Use of the Svyatogor mechs allowed them to succeed, and to this day they are still proud of their independent efforts. With the mechanized labor industry returning to prominence, Russia entered a period of economic growth. With the beginning of the Second Omnic Crisis, Svyatogor factories across Russia have increased production. Among them, Volskaya Industries is one of the heads of the industry. In Infiltration, Reaper, Widowmaker, and Sombra break into Volskaya Industries to assassinate its CEO, Katya Volskaya. Sombra managed to confront her, but chose to blackmail her instead.',
    '<ul><li>The mechs in the background will occasionally dance.</li></br><li>Near the first point, there is a large mural of Zarya on a wall.</li></br></ul>',
    '',
    0,
    1
);
INSERT INTO map (name, canonical_name, location, gamemode, description, background, easter_eggs, strategy, is_favorite, id_locale) VALUES (
    'Ilios',
    'ilios',
    'Greece',
    'Control',
    'Ilios is one of the locations in Overwatch. It is a Control map. It has three stages: Lighthouse, Well, and Ruins. Situated atop a small island rising from the Aegean Sea, Ilios is a postcard-perfect Mediterranean town, with a bustling harbourside, winding paths for rambling hillside strolls, and gorgeous vistas. It is the ideal vacation stop for people looking for a place to relax, or for those interested in exploring the ruins scattered at the top of the island, where many artifacts and relics of the ancient world have been recently unearthed.',
    'Ilios is a small Greek island in the Aegean Sea that is very popular with tourists. Atop the island, there is an archaeology site where ancient Greek statues and mosaics have been discovered. Talon activity has been seen in the area, and Athena believes they are interested in the artifacts.',
    '<ul><li>In the Kofi Aromo by the Lighthouse, there is a tablet with Hearthstone open.</li></br><li>In the fishing shop by the Lighthouse, there are boxes of Murk Bait for sale.</li></br><li>In two houses, one on each side of the Well, there are TVs with the brand label Samwise, a shout-out to Samwise Didier, WoW''s Art Director.</li></br><li>The Well is similar to the Pit of Death in the movie ''300'' that is also set in Greece.</li></br></ul>',
    '',
    0,
    1
);
INSERT INTO map (name, canonical_name, location, gamemode, description, background, easter_eggs, strategy, is_favorite, id_locale) VALUES (
    'Népal',
    'nepal',
    'Himalayas, Nepal',
    'Control',
    'Nepal is one of the locations in Overwatch. It is a Control map. It has three stages: Village, Shrine, and Sanctum. Years ago, a group of omnic robots experienced what they described as a spiritual awakening. They abandoned their preprogrammed lives to establish a monastery high in the Himalayas of Nepal, where like-minded omnics could gather to meditate on the nature of their existence. Led by their spiritual leader, Tekhartha Mondatta, they took over the ruins of an ancient monastery and turned it into the home of the Shambali, a place where omnics and humans alike make pilgrimages in the hopes of finding a greater truth.',
    'After the Omnic Crisis, a monastery was founded in the Himalayas by a group of omnics who had experienced a spiritual awakening. Under the leadership of Tekhartha Mondatta, the Shambali preached unity and equality wherever omnics were mistreated. The monastery became a popular site of pilgrimage for both omnics and humans. One Shambali member, Tekhartha Zenyatta, left the monastery over a disagreement over how they should spread their message. His pupil, Genji, still lives in the village below.',
    '<ul><li>The three stages are arranged like a staircase, with Village at the bottom, Shrine in the middle, and Sanctum at the top.</li></br><li>Between the cliff and the capture point on Village, on second floor, there is a room that is implied to be Genji''s. It contains a Shimada haori, a smaller version of the large painting from Hanamura''s last point (in Beta version), a katana stand, and a photo of young Hanzo and young Genji standing side by side.</li></br><li>One of the shops is named "Ravenwood''s Kitchen", a shoutout to Indiana Jones movies where a character named Marion Ravenwood has a tavern in Nepal.</li></br></ul>',
    '',
    0,
    1
);
INSERT INTO map (name, canonical_name, location, gamemode, description, background, easter_eggs, strategy, is_favorite, id_locale) VALUES (
    'Tour de Lijiang',
    'tourdelijiang',
    'Lijiang, China',
    'Control',
    'Lijiang Tower is one of the locations in Overwatch. It is a Control map. It has three stages: Night Market, Garden, and Control Center. Lijiang Tower was built in the heart of a modern Chinese metropolis, its busy streets lined with stores, gardens, restaurants, and famous night markets, where foods from around the region are available at all hours. The tower itself is home to one of the leading companies in China’s state-of-the-art space industry, Lucheng Interstellar, an organization with a long pioneering history that is currently pushing the boundaries of space exploration.',
    'In the center of the city of Lijiang, a large tower looms above the city owned by Lucheng Interstellar, China''s leading space exploration company. Lucheng is known for establishing the Horizon Lunar Colony and a space station, the Interstellar Journey (though the former was overrun by gorillas and the latter is encountering errors).',
    '<ul><li>The map is arranged like a staircase, with Night Market at the bottom, Garden in the middle, and Control Center at the top.</li></br><li>In the Night Market, there is an electric billboard in front of the pagoda, showing the news in simplified Chinese:</li></br><ul><li>据报道:侠盗"士兵76"在墨西哥多拉多现身</li></br><li>署名的气候学家周美灵重返喜马拉雅</li></br><li>“星际旅程”空间站突发紧急故障</li></br><li>“猎空”和温斯顿再次现身，守望先鋒回来了？</li></br><li>古希腊雕像在伊利奥斯重现天日</li></br></ul><li>Posters for the Horizon Lunar Colony can be seen in rooms around the Control Center.</li></br><li>In the Control Center, there are spacesuits on display; one is red with no flag, one is blue with the USA''s flag, and one is green with Numbani''s flag.The red spacesuit is marked with the name "宏宇" and has the phrase "英雄不朽" on the wall behind it. This is in honor of Hongyu Wu (吴宏宇), an avid fan of Overwatch who died trying to pursue a motorcycle thief.</li></br><li>At a desk in the Control Center, there is a photo of Dr. Harold Winston and young Winston.</li></br></ul>',
    '',
    0,
    1
);