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

--Skills Attaque
--Genji
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Shuriken', 'Genji lance trois shurikens mortels en succession rapide. Il peut également lancer trois shurikens en éventail.', '', 2);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Riposte', 'Avec des moulinets de son épée aussi rapides que l’éclair, Genji dévie les attaques et les renvoie vers ses adversaires.', '', 2);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Frappe du vent', 'Genji file en avant, tranchant l’air de son katana et traversant les ennemis sur son passage. Si Genji élimine un adversaire grâce à cette capacité, il peut s’en servir immédiatement à nouveau.', '', 2);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Lame du dragon', 'Genji brandit son katana pendant une courte période. Il peut délivrer des coups mortels à toutes les cibles à portée jusqu’à ce qu’il rengaine son sabre.', '', 2);
--McCree
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Pacificateur', 'McCree tire avec son fidèle six-coups. Il peut aussi actionner directement le chien pour vider très rapidement tout son barillet.', '', 3);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Roulade', 'McCree plonge dans la direction de son déplacement et se redresse en ayant rechargé son revolver.', '', 3);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Grenade Flash', 'McCree jette une grenade aveuglante qui explose peu après avoir quitté sa main. La déflagration étourdit les ennemis dans un petit rayon.', '', 3);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Implacable', 'Concentration. Appréciation. Prise en main. McCree prend quelques précieux instants pour viser. Quand il se décide à tirer, il abat tous les ennemis dans son champ de vision. Plus ses cibles sont faibles, moins il aura besoin de viser pour que le tir soit mortel.', '', 3);
--Pharah
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Lance-roquettes Falcon', 'Pharah utilise son arme principale pour envoyer des roquettes qui infligent des dégâts significatifs dans une large zone de déflagration.', '', 4);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Réacteurs', 'Propulsée par les réacteurs de son armure, Pharah peut s’élever en altitude.', '', 4);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Conflagration', 'Pharah libère une roquette qui repousse violemment tous les ennemis avec lesquels elle entre en contact.', '', 4);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Barrage', 'Pharah dirige une salve continue de mini-roquettes pour détruire des groupes d’ennemis.', '', 4);
--Faucheur
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Pompes funèbres', 'Faucheur met ses ennemis en pièces avec ses deux fusils à pompe.', '', 1);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Forme spectrale', 'Faucheur devient une ombre pendant une courte période. Sous cette forme spectrale, il ne peut être blessé et il est capable de passer au travers de ses ennemis mais ne peut pas utiliser son armement ou ses autres capacités.', '', 1);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Voie des ombres', 'Après avoir marqué une destination de son choix, Faucheur disparaît pour réapparaître à cet endroit.', '', 1);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Éclosion mortelle', 'Quasi indiscernable, Faucheur vide ses deux fusils à pompe à tombeau ouvert, infligeant de très lourds dégâts à tous les ennemis proches.', '', 1);
--Soldat76
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Fusil à impulsions', 'Le fusil à impulsions entièrement automatique du soldat : 76 reste particulièrement stable lorsque ce dernier vide son chargeur.', '', 5);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Roquettes LX', 'Le fusil à impulsions du soldat : 76 tire plusieurs petites roquettes à la fois. L’explosion des roquettes inflige des dégâts aux ennemis dans une petite zone.', '', 5);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Sprint', 'Qu’il ait besoin de fuir les tirs ennemis ou de revenir au combat rapidement, le soldat : 76 peut foncer droit devant lui. Toute action autre qu’une course vers l’avant met fin à son Sprint.', '', 5);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Champ biotique', 'Le soldat : 76 pose au sol un émetteur biotique. L’énergie ainsi projetée soigne 76 et ses équipiers qui se trouvent dans le champ d’action.', '', 5);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Visière tactique', 'La visière tactique de localisation du soldat : 76 « verrouille » la menace la plus proche de son viseur. Si un ennemi quitte son champ de vision, le soldat : 76 peut rapidement changer de cible.', '', 5);
--Sombra
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Pistolet mitrailleur', 'Le pistolet mitrailleur automatique de Sombra tire à courte portée.', '', 7);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Piratage', 'Sombra peut pirater ses ennemis et les priver temporairement de leurs capacités, ou corrompre les kits de soins pour empêcher ses adversaires de s’en servir.', '', 7);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Camouflage thermoptique', 'Sombra devient invisible pour une courte période, pendant laquelle sa vitesse augmente considérablement. Le camouflage est désactivé si vous attaquez, si vous utilisez des capacités offensives ou si vous subissez des dégâts.', '', 7);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Transducteur', 'Sombra lance une balise de transduction vers laquelle elle peut se téléporter instantanément tant que celle-ci est active (même si la balise se trouve encore dans les airs).', '', 7);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('IEM', 'Sombra génère une large vague d’énergie électromagnétique qui désactive les boucliers ennemis et pirate tous les adversaires touchés par l’onde de choc.', '', 7);
--Tracer
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Pulseurs', 'Tracer a une cadence de tir très rapide grâce à ses pistolets.', '', 6);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Transfert', 'Tracer fonce droit devant elle et réapparaît quelques mètres plus loin. Elle peut cumuler jusqu’à trois charges de transfert, et en génère régulièrement à quelques secondes d’intervalle.', '', 6);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Rappel', 'Tracer bondit en arrière dans le temps et récupère les points de vie et les munitions dont elle disposait, ainsi que sa position précise sur la carte quelques secondes plus tôt.', '', 6);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Bombe à impulsions', 'Tracer lance une grosse charge explosive qui adhère à n’importe quelle surface, ou à l’adversaire ayant le malheur de la recevoir. Après un court délai, la bombe explose en infligeant des dégâts importants à tous les ennemis dans la zone de déflagration.', '', 6);

--Skills Defense
--Bastion
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Configuration : Reconnaissance', 'En mode Reconnaissance, Bastion est parfaitement mobile et équipé d’une mitrailleuse légère qui tire des rafales régulières et est efficace à moyenne portée.', '', 8);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Configuration : Sentinelle', 'En mode Sentinelle, Bastion est une centrale électrique statique, protégée par un écran frontal et équipée d’une mitrailleuse rotative capable de déchaîner une pluie de balles. L’arme peut effectuer un « balayage » dévastateur à courte ou moyenne portée.', '', 8);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Reconfiguration', 'Bastion passe d’un mode de combat à l’autre afin de s’adapter aux conditions du champ de bataille.', '', 8);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Autoréparation', 'Bastion récupère ses points de vie, mais ses systèmes d’armement sont désactivés et il reste immobile jusqu’à la fin de la réparation.', '', 8);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Configuration : Tank', 'En mode Tank, Bastion déploie des chenilles et un puissant canon à longue portée. Les tirs explosifs du canon démolissent les cibles présentes dans son large rayon d’explosion, mais Bastion ne peut conserver ce mode que pour un temps limité.', '', 8);
--Hanzo
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Arc tempête', 'Hanzo encoche une flèche et la décoche sur sa cible.', '', 9);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Flèche sonique', 'Hanzo projette une flèche équipée d’un sonar ; celle-ci marque tous les ennemis dans son rayon de détection et les rend plus faciles à traquer pour Hanzo et ses alliés.', '', 9);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Mille-flèches', 'Hanzo tire une flèche qui se fragmente en plusieurs projectiles. Ceux-ci ricochent sur les murs et les objets, et peuvent frapper plusieurs cibles.', '', 9);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Frappe du dragon', 'Hanzo invoque l’esprit d’un dragon qui fend les airs devant lui. Il traverse les murs sur son passage et dévore tous les ennemis rencontrés.', '', 9);
--Chacal
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Lance-grenades', 'Le lance-grenades de Chacal projette des grenades sur une bonne distance. Elles rebondissent pour atteindre leur destination et explosent quand elles frappent un ennem', '', 10);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Mine incapacitante', 'Après avoir placé une de ses mines incapacitantes maison, Chacal peut la déclencher pour blesser les ennemis et les faire voler dans les airs... ou se propulser lui-même en l’air.', '', 10);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Piège d''acier', 'Chacal balance un piège géant à mâchoire métallique. Si un ennemi s’approche trop près du piège, il se referme, l’immobilisant et le blessant.', '', 10);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Mauvais perdant', 'Le sens de l''humour complètement azimuté de Chacal subsiste après sa mort : s’il est tué, il largue plusieurs grenades dégoupillées.', '', 10);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Pneumastic', 'Chacal fait vrombir une bombe-pneu motorisée qui peut grimper sur les murs et les obstacles, et l’envoie rouler sur le champ de bataille. Il peut faire détoner le pneumastic à distance pour infliger d''importants dégâts aux ennemis pris dans l’explosion, ou simplement attendre qu’il explose de lui-même.', '', 10);
--Mei
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Canon endothermique', 'Le blaster de Mei libère un flux de givre concentré à courte portée qui endommage, ralentit et finit par geler sur place les ennemis. Mei peut aussi s’en servir pour tirer des glaçons à portée moyenne.', '', 11);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Cryostase', 'Mei s’entoure instantanément d''un épais bloc de glace. Elle se soigne et échappe aux dégâts tant qu’elle est à l’intérieur, mais elle ne peut ni se déplacer, ni utiliser de capacités.', '', 11);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Mur de glace', 'Mei génère un énorme mur de glace qui bouche les lignes de vue, empêche le déplacement et bloque les attaques.', '', 11);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Blizzard', 'Mei déploie un drone de modification du climat qui émet des bourrasques de vent et de neige dans une large zone. Les ennemis pris dans le blizzard sont ralentis et subissent des dégâts, et ceux qui s’attardent trop longtemps sont complètement gelés.', '', 11);
--Torbjörn
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Pistolet à rivets', 'Avec son pistolet, Torbjörn tire des rivets à longue portée ou des projectiles de métal surchauffé en petites rafales à courte portée.', '', 12);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Marteau de forge', 'Torbjörn utilise son marteau polyvalent pour construire, améliorer et réparer des tourelles, et peut l’utiliser comme arme en cas d’urgence.', '', 12);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Déploiement de tourelle', 'Torbjörn construit un canon automatique avec un système de suivi des ennemis. Il peut utiliser la ferraille récupérée sur les ennemis ou alliés abattus pour l’améliorer, augmentant ses points de vie et y ajoutant un second canon et un lance-roquettes.', '', 12);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Module d''armure', 'Torbjörn fabrique des pièces d’armure que lui-même ou ses alliés peuvent ramasser pour absorber une partie des dégâts.', '', 12);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Coeur de magma', 'Déclencher la surchauffe de sa forge personnelle permet à Torbjörn de gagner une quantité significative d’armure et de ferraille, mais aussi d’attaquer (et de construire ou de réparer des tourelles) bien plus rapidement qu’en temps normal.', '', 12);
--Fatale
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Baiser de la veuve', 'Fatale est équipée d’un fusil polyvalent idéal pour abattre à la lunette les cibles les plus lointaines. Il peut aussi être utilisé en mode automatique sur les cibles à moyenne portée.', '', 13);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Grappin', 'Fatale peut envoyer un grappin vers la position qu’elle vise. Une fois le grappin arrimé, elle est rapidement attirée le long de son câble, ce qui lui permet d’améliorer sa visibilité du champ de bataille et d’esquiver ou de contourner des cibles.', '', 13);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Mine venimeuse', 'Fatale applique des mines venimeuses à armement rapide qui adhèrent à quasiment n’importe quelle surface. Lorsqu’une cible s’aventure à portée du détecteur de mouvement intégré à la mine, cette dernière explose en dégageant un gaz empoisonné qui affecte tous les ennemis à proximité.', '', 13);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Infravision', 'La visière de reconnaissance de Fatale lui permet de voir la signature thermique de ses cibles, même au travers des murs ou autres obstacles pendant un certain temps. Cette perception améliorée est partagée avec ses alliés.', '', 13);
--Skills Tank
--D.va
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Fusio-canons', 'Le méca de D.VA est équipé de canons rotatifs jumelés à courte portée. Activés, ils infligent d’importants dégâts continus sans avoir besoin d’être rechargés, mais ils ralentissent les déplacements de D.Va.', 'N/A', 14);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Pistolaser', 'Lorsqu’elle est hors de son méca, D.Va peut continuer le combat avec une arme automatique à moyenne portée.', 'N/A', 14);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Turboréacteurs', 'Le méca se projette dans les airs et D.Va est propulsée en avant par l’inertie. Elle peut tourner et changer de direction ou foncer sur ses ennemis, les projetant en arrière.', 'N/A', 14);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Matrice défensive', 'D.Va peut activer son système de ciblage avant pour abattre en l’air les projectiles qui se dirigent vers elle.', 'N/A', 14);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Autodestruction', 'D.Va s’éjecte de son méca et fait sauter son réacteur. L’explosion inflige des dégâts considérables aux adversaires proches.', 'N/A', 14);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Appel du Méca', 'Si son armure de combat blindée est détruite, D.Va peut appeler un nouveau méca et reprendre le combat.', 'N/A', 14);
--Reinhardt
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Marteau à réaction', 'Le marteau à réaction de Reinhardt est une arme de combat rapproché exemplaire, capable d’infliger des dégâts brutaux sur un large arc à chaque coup.', '', 15);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Écran', 'Reinhardt déploie devant lui un large écran énergétique qui peut absorber une grande quantité de dégâts avant de disparaître. Reinhardt peut se protéger ainsi que ses compagnons qui se trouvent derrière l’écran, mais il ne peut pas attaquer pendant qu’il le maintient en place.', '', 15);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Charge', 'Reinhardt charge droit devant lui et saisit le premier ennemi qui se trouve sur son chemin. S’il entre en collision avec un mur, les adversaires qu’il porte sont écrasés et subissent des dégâts extrêmes.', '', 15);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Frappe de feu', 'En faisant tournoyer son marteau devant lui, Reinhardt envoie un projectile enflammé qui transperce et inflige des dégâts à tous les ennemis qu’il touche.', '', 15);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Choc sismique', 'Reinhardt abat son marteau à réaction sur le sol, ce qui blesse et renverse tous les ennemis devant lui', '', 15);
--Chopper
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Déferrailleur', 'Le déferrailleur de Chopper lance du shrapnel à courte portée mais sur une large zone. Sinon il peut lancer une boule de shrapnels qui détone plus loin, éparpillant les fragments métalliques depuis le point d’impact.', '', 16);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Inhalateur', 'Chopper récupère une partie de ses points de vie sur une courte période.', '', 16);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Traquelard', 'Chopper lance sa chaîne vers une cible ; s’il l’attrape, il l’attire à lui, à courte portée.', '', 16);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Équarisseur', 'Après avoir ajouté un chargeur supplémentaire au-dessus de son déferrailleur, Chopper le bourre de munitions. Pendant une courte période, il mitraille une large zone devant lui avec des shrapnels qui repoussent les ennemis.', '', 16);
--Winston
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Canon Tesla', 'Tant que Winston garde le doigt sur la gâchette, son arme envoie un flot de décharges électriques à courte portée.', '', 17);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Propulseurs', 'Winston bondit dans les airs avec l’aide de sa réserve d’énergie dorsale et retombe en infligeant des dégâts significatifs et en étourdissant les ennemis proches.', '', 17);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Générateur d''écran', 'Le générateur d’écran de Winston projette un champ de force en forme de bulle qui absorbe les dégâts jusqu’à sa destruction. Les alliés à l’intérieur sont protégés et peuvent tirer.', '', 17);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Rage primordiale', 'Winston embrasse sa nature animale, augmentant notablement ses points de vie et le rendant très difficile à tuer, renforçant ses attaques en mêlée et lui permettant d’utiliser ses propulseurs plus souvent. Quand il est enragé, Winston ne peut utiliser que les propulseurs et les attaques au corps à corps.', '', 17);
--Zarya
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Canon à particules', 'Le puissant canon à particules de Zarya déchaîne un rayon d’énergie destructrice à courte portée. Zarya peut également s’en servir pour projeter une charge explosive capable de blesser plusieurs adversaires.', '', 18);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Écran de particules', 'Le canon à particules peut émettre une barrière individuelle qui protège Zarya contre les attaques la ciblant, absorbant leur énergie pour augmenter les dégâts et la largeur du rayon de son arme.', '', 18);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Écran généré', 'Zarya englobe l’un de ses coéquipiers dans une barrière d’énergie qui absorbe les coups et renforce la puissance de son canon à particules.', '', 18);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Orbe à gravitons', 'Zarya lance une bombe gravitationnelle qui attire les combattants ennemis et les blesse tant qu’ils restent piégés.', '', 18);
--Skills Support
--Ana
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Fusil biotique', 'Le fusil d’Ana projette des fléchettes qui régénèrent les points de vie de ses alliés ou infligent des dégâts continus à ses ennemis. La lunette de son fusil lui permet de zoomer sur ses cibles pour des tirs d’une extrême précision.', '', 19);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Fléchette hypodermique', 'Ana tire une fléchette avec son arme de poing, provoquant l’évanouissement d’un ennemi (qui se réveille s’il subit des dégâts)', '', 19);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Grenade biotique', 'Ana lance une bombe biotique qui inflige des dégâts aux ennemis et soigne les alliés dans une zone de taille réduite. Pendant un court moment, les alliés affectés reçoivent plus de soins de toutes les sources, tandis que les ennemis pris dans l’explosion ne peuvent temporairement plus être soignés.', '', 19);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Nanoboost', 'Lorsqu’ils reçoivent un bonus de combat de la part d’Ana, ses alliés se déplacent temporairement plus vite, infligent plus de dégâts et résistent mieux aux attaques ennemies.', '', 19);
--Lúcio
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Ampli', 'Lúcio peut frapper ses ennemis à l’aide de projectiles soniques ou les repousser avec une onde de choc sonore.', '', 20);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Crossfade', 'Lúcio se stimule constamment, ainsi que ses équipiers proches, grâce à la musique. Il peut alterner entre deux chansons : l’une augmente la vitesse de déplacement, la seconde rend des points de vie.', '', 20);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Volume max.', 'Lúcio augmente le volume de ses enceintes, ce qui améliore l’effet de ses chansons.', '', 20);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Mur de son', 'Des vagues protectrices irradient de l’ampli de Lúcio et lui procurent ainsi qu’à ses alliés proches des boucliers personnels.', '', 20);
--Ange
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Caducée', 'Ange projette un des deux rayons sur un allié. En maintenant les rayons, elle peut soigner l’allié ciblé ou augmenter les dégâts qu’il inflige.', '', 21);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Miséricorde', 'Ange peut tirer avec cette arme de poing, qu’il vaut mieux conserver pour sa protection personnelle.', '', 21);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Ange gardien', 'Ange vole vers un allié ciblé. Elle peut ainsi rejoindre rapidement ses coéquipiers pour mieux les assister dans les moments cruciaux.', '', 21);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Saut de l''ange', 'Grâce aux propulseurs de son armure Valkyrie, Ange peut ralentir sa vitesse de chute et descendre de n’importe quelle hauteur.', '', 21);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Résurrection', 'Ange irradie de puissance restauratrice et ranime les alliés morts autour d’elle avec la totalité de leurs points de vie.', '', 21);
--Symmetra
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Projecteur à photons', 'L’arme de Symmetra émet un rayon à courte portée qui se focalise sur un ennemi proche, lui infligeant des dégâts continus qui augmentent sur la durée. Le projecteur peut aussi envoyer une boule d’énergie surchargée qui inflige des dégâts importants.', '', 22);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Tourelle sentinelle', 'Symmetra installe une petite tourelle qui projette automatiquement des décharges réduisant la vitesse de l’ennemi le plus proche à sa portée. Plusieurs tourelles peuvent être déployées simultanément sur le champ de bataille.', '', 22);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Bouclier à photons', 'Symmetra enveloppe un allié dans un bouclier photoformé qui absorbe les dégâts et subsiste aussi longtemps que l’allié reste en vie.', '', 22);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Téléporteur', 'Symmetra place un socle d’arrivée à sa position actuelle et le connecte à celui placé au point de départ de son équipe. Les alliés peuvent voyager instantanément d’un socle à l’autre, ce qui leur permet de retourner rapidement au combat après avoir été abattus.', '', 22);
--Zenyatta
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Orbe de destruction', 'Zenyatta lance ses orbes d’énergie destructrice soit individuellement, soit en rafale après avoir passé quelques secondes à rassembler de l’énergie.', '', 23);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Orbe d''harmonie', 'Zenyatta lance un orbe au-dessus d’un allié ciblé. Tant que Zenyatta reste en vie, l’orbe restaure lentement les points de vie de cet allié. Ne peut être utilisé que sur un allié à la fois.', '', 23);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Orbe de discorde', 'Lancer un orbe de discorde sur un ennemi amplifie la quantité de dégâts que celui-ci reçoit tant que Zenyatta est en vie. Ne peut être utilisé que sur un adversaire à la fois.', '', 23);
INSERT INTO skill (name, description, features, id_heroes) VALUES ('Transcendance', 'Zenyatta parvient à accéder à un stade d’existence supérieur pendant un court moment. Tant qu’il se transcende, Zenyatta ne peut pas utiliser ses capacités ou ses armes, mais il est immunisé aux dégâts et restaure automatiquement ses points de vie et ceux des alliés proches.', '', 23);

