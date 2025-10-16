-- =========================
-- UNIVERSOS
-- =========================
INSERT INTO universes (id, name, description) VALUES
(1, 'Universal Century (UC)', 'Línea de tiempo principal de Gundam'),
(2, 'Alternate Universe (AU)', 'Universos alternativos de Gundam');

-- =========================
-- ERAS - UNIVERSAL CENTURY (UC)
-- =========================
INSERT INTO eras (id, name, description, universe_id, chronological_order, is_canonical) VALUES
(1, 'Pre-Guerra de Un Año', 'Eventos anteriores al conflicto principal entre la Federación de la Tierra y el Principado de Zeon', 1, 1, true),
(2, 'Guerra de Un Año (0079)', 'Conflicto principal entre la Federación de la Tierra y el Principado de Zeon (UC 0079)', 1, 2, true),
(3, 'Post-Guerra de Un Año', 'Consecuencias inmediatas de la Guerra de Un Año y el surgimiento de nuevos conflictos', 1, 3, true),
(4, 'Conflictos de Gryps', 'Guerra civil entre los Titans y AEUG en la colonia Gryps', 1, 4, true),
(5, 'Primera Guerra Neo-Zeon', 'Conflicto con Axis Zeon liderado por Haman Karn', 1, 5, true),
(6, 'Segunda Guerra Neo-Zeon', 'Conflicto final con Char Aznable y su ejército Neo-Zeon', 1, 6, true),
(7, 'Late Universal Century', 'Eventos posteriores al UC 0096 incluyendo el incidente de Laplace', 1, 7, true),
(8, 'Far Future UC', 'Era distante del UC incluyendo F91 y Victory Gundam', 1, 8, true);

-- =========================
-- ERAS - ALTERNATE UNIVERSE (AU)
-- =========================
INSERT INTO eras (id, name, description, universe_id, chronological_order, is_canonical) VALUES
(9, 'Future Century', 'Universo de G Gundam donde las guerras se resuelven con torneos de Gundam', 2, 1, true),
(10, 'After Colony', 'Universo de Gundam Wing con las colonias espaciales luchando por la independencia', 2, 2, true),
(11, 'After War', 'Universo post-apocalíptico de Gundam X después de la Guerra de los Siete Días', 2, 3, true),
(12, 'Correct Century', 'Universo de Turn A Gundam que converge todas las líneas temporales', 2, 4, true),
(13, 'Cosmic Era', 'Universo de Gundam SEED con el conflicto entre Coordinadores y Naturales', 2, 5, true),
(14, 'Anno Domini', 'Universo de Gundam 00 con el conflicto por recursos energéticos', 2, 6, true),
(15, 'Advanced Generation', 'Universo de Gundam AGE que abarca múltiples generaciones', 2, 7, true),
(16, 'Post Disaster', 'Universo de Iron-Blooded Orphans 300 años después de la Calamity War', 2, 8, true),
(17, 'Ad Stella', 'Universo de The Witch from Mercury en la academia espacial Asticassia', 2, 9, true),
(18, 'Build Series', 'Meta-universo donde los personajes construyen y pelean con modelos Gunpla', 2, 10, false),
(19, 'Contenido Experimental', 'Shorts, parodias, proyectos especiales y contenido no canónico', 2, 11, false),
(20, 'GQuuuuuuX Timeline', 'Nueva línea temporal iniciada en 2025 con Gundam GQuuuuuuX', 2, 12, true);

-- =========================
-- SERIES UNIVERSAL CENTURY (UC)
-- =========================
-- Pre-Guerra de Un Año
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(1, 'Mobile Suit Gundam: The Origin', 2015, 'OVA', 6.0, 1, 1),
(2, 'MS IGLOO: The Hidden One Year War', 2004, 'OVA', 1.5, 1, 1),
(3, 'MS IGLOO: Apocalypse 0079', 2006, 'OVA', 1.5, 1, 1),
(4, 'MS IGLOO 2: Gravity Front', 2006, 'OVA', 1.5, 1, 1);

-- Guerra de Un Año
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(5, 'Mobile Suit Gundam 0079', 1979, 'TV', 17.56, 1, 2),
(6, 'Mobile Suit Gundam: Cucuruz Doan''s Island', 2022, 'Movie', 1.75, 1, 2),
(7, 'Mobile Suit Gundam: The 08th MS Team', 1996, 'OVA', 4.9, 1, 2),
(8, 'Miller''s Report', 1998, 'Special', 0.6, 1, 2),
(9, 'Thunderbolt: December Sky', 2016, 'Movie', 1.67, 1, 2),
(10, 'Thunderbolt: Bandit Flower', 2017, 'Movie', 1.5, 1, 2),
(11, 'Mobile Suit Gundam 0080: War in the Pocket', 1989, 'OVA', 2.45, 1, 2),
(12, 'Mobile Suit Gundam: Requiem for Vengeance', 2024, 'ONA', 2.0, 1, 2),
(13, 'Gundam Evolve (UC-relevant shorts)', 2001, 'Special', 1.07, 1, 2);

-- Post-Guerra de Un Año
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(14, 'Mobile Suit Gundam 0083: Stardust Memory', 1991, 'OVA', 5.31, 1, 3);

-- Conflictos de Gryps
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(15, 'Mobile Suit Zeta Gundam', 1985, 'TV', 20.42, 1, 4);

-- Primera Guerra Neo-Zeon
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(16, 'Mobile Suit Gundam ZZ', 1986, 'TV', 19.19, 1, 5),
(59, 'Mobile Suit Gundam: ZZ Special Edition', 1989, 'OVA', 4.0, 1, 5),
(60, 'Mobile Suit Gundam: Evolve 9 (ZZ Gundam)', 2004, 'Special', 0.08, 1, 5);

-- Segunda Guerra Neo-Zeon
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(17, 'Mobile Suit Gundam: Char''s Counterattack', 1988, 'Movie', 2.0, 1, 6);

-- Late UC
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(18, 'Mobile Suit Gundam Unicorn', 2010, 'OVA', 7.0, 1, 7),
(19, 'Mobile Suit Gundam Twilight Axis', 2017, 'ONA', 0.43, 1, 7),
(20, 'Mobile Suit Gundam Narrative', 2018, 'Movie', 1.5, 1, 7),
(21, 'Mobile Suit Gundam Hathaway', 2021, 'Movie', 1.72, 1, 7);

-- Far Future UC
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(22, 'Mobile Suit Gundam F91', 1991, 'Movie', 1.92, 1, 8),
(23, 'Mobile Suit Victory Gundam', 1993, 'TV', 20.83, 1, 8),
(24, 'G-Saviour', 2000, 'Live-action', 1.55, 1, 8);

-- =========================
-- SERIES ALTERNATE UNIVERSE (AU)
-- =========================
-- Future Century (G Gundam)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(25, 'Mobile Fighter G Gundam', 1994, 'TV', 20.01, 2, 9),
(26, 'Kidou Butouden G Gundam (Especiales)', 2004, 'OVA', 0.83, 2, 9);

-- After Colony (Gundam Wing)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(27, 'Gundam Wing', 1995, 'TV', 20.01, 2, 10),
(28, 'Endless Waltz', 1997, 'Movie', 1.5, 2, 10);

-- After War (Gundam X)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(29, 'After War Gundam X', 1996, 'TV', 15.93, 2, 11);

-- Correct Century (Turn A Gundam)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(30, 'Turn A Gundam', 1999, 'TV', 20.42, 2, 12),
(31, 'Turn A Gundam: Earth Light', 2002, 'Movie', 2.0, 2, 12),
(32, 'Turn A Gundam: Moonlight Butterfly', 2002, 'Movie', 2.17, 2, 12);

-- Cosmic Era (Gundam SEED)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(33, 'Gundam SEED', 2002, 'TV', 20.42, 2, 13),
(34, 'Gundam SEED MSV Astray', 2004, 'OVA', 0.17, 2, 13),
(35, 'Gundam SEED Destiny', 2004, 'TV', 20.42, 2, 13),
(36, 'SEED C.E.73: Stargazer', 2006, 'OVA', 0.75, 2, 13),
(37, 'Gundam SEED Freedom', 2024, 'Movie', 2.07, 2, 13);

-- Anno Domini (Gundam 00)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(38, 'Gundam 00 Season 1', 2007, 'TV', 10.21, 2, 14),
(61, 'Gundam 00 Season 2', 2008, 'TV', 10.21, 2, 14),
(39, '00: Awakening of the Trailblazer', 2010, 'Movie', 2.0, 2, 14);

-- Advanced Generation (Gundam AGE)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(40, 'Gundam AGE', 2011, 'TV', 20.01, 2, 15),
(41, 'Gundam AGE: Memory of Eden', 2013, 'OVA', 2.5, 2, 15);

-- Post Disaster (Gundam IBO)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(42, 'Iron-Blooded Orphans Season 1', 2015, 'TV', 10.21, 2, 16),
(62, 'Iron-Blooded Orphans Season 2', 2016, 'TV', 10.21, 2, 16);

-- Ad Stella (Gundam Witch)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(43, 'The Witch from Mercury', 2022, 'TV', 9.8, 2, 17);

-- Build Series
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(48, 'Gundam Build Fighters', 2013, 'TV', 10.42, 2, 18),
(49, 'Gundam Build Fighters Try', 2014, 'TV', 10.42, 2, 18),
(50, 'Gundam Build Divers', 2018, 'TV', 10.0, 2, 18),
(51, 'Gundam Build Divers Re:RISE', 2019, 'TV', 10.4, 2, 18),
(52, 'Gundam Build Metaverse', 2023, 'ONA', 0.5, 2, 18);

-- Contenido Experimental
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(44, 'Gundam-san', 2014, 'Special', 0.65, 2, 19),
(45, 'Gundam Evolve (non-UC shorts)', 2001, 'Special', 1.07, 2, 19),
(46, 'Gundam Moon', 2024, 'Short', 0.17, 2, 19),
(47, 'SD Gundam Force', 2004, 'TV', 19.07, 2, 19),
(53, 'Gundam THE RIDE: A Baoa Qu', 2000, 'Short', 0.08, 2, 19),
(54, 'Gundam Neo Experience 0087: Green Divers', 2001, 'Short', 0.4, 2, 19);

-- Otros proyectos
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(55, 'Gundam Reconguista in G (TV)', 2014, 'TV', 10.4, 2, 19),
(56, 'Gundam Reconguista in G (Movies I-V)', 2019, 'Movie', 8.33, 2, 19);

-- GQuuuuuuX (2025)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id, era_id) VALUES
(57, 'Mobile Suit Gundam GQuuuuuuX: Beginning', 2025, 'Movie', 1.35, 2, 20),
(58, 'Mobile Suit Gundam GQuuuuuuX (TV)', 2025, 'TV', 4.8, 2, 20);

-- =========================
-- TEMPORADAS (SEASONS) - COMPLETO
-- =========================

-- MS IGLOO (3 temporadas)
INSERT INTO seasons (series_id, season_number, title, description, release_year, type, hours_length, chronological_order, episode_count) VALUES
(2, 1, 'MS IGLOO: The Hidden One Year War', 'Primera temporada que muestra perspectivas únicas de la Guerra de Un Año', 2004, 'OVA', 1.5, 1, 3),
(3, 2, 'MS IGLOO: Apocalypse 0079', 'Segunda temporada continuando las historias del frente de batalla', 2006, 'OVA', 1.5, 2, 3),
(4, 3, 'MS IGLOO 2: Gravity Front', 'Tercera temporada enfocada en operaciones terrestres', 2006, 'OVA', 1.5, 3, 3);

-- The 08th MS Team (2 partes)
INSERT INTO seasons (series_id, season_number, title, description, release_year, type, hours_length, chronological_order, episode_count) VALUES
(7, 1, 'The 08th MS Team', 'Serie principal sobre el equipo terrestre', 1996, 'OVA', 4.9, 1, 12),
(8, 2, 'Miller''s Report', 'Especial que resume y expande la historia', 1998, 'SPECIAL', 0.6, 2, 1);

-- Thunderbolt (2 temporadas/películas)
INSERT INTO seasons (series_id, season_number, title, description, release_year, type, hours_length, chronological_order, episode_count) VALUES
(9, 1, 'Thunderbolt: December Sky', 'Primera parte del intenso conflicto en el sector Thunderbolt', 2016, 'MOVIE', 1.67, 1, 1),
(10, 2, 'Thunderbolt: Bandit Flower', 'Continuación de la batalla entre la Federación y Zeon', 2017, 'MOVIE', 1.5, 2, 1);

-- Gundam 00 (3 partes)
INSERT INTO seasons (series_id, season_number, title, description, release_year, type, hours_length, chronological_order, episode_count) VALUES
(38, 1, 'Gundam 00 Season 1', 'Primera temporada: Celestial Being se revela', 2007, 'TV', 10.21, 1, 25),
(61, 2, 'Gundam 00 Season 2', 'Segunda temporada: 4 años después', 2008, 'TV', 10.21, 2, 25),
(39, 3, 'Awakening of the Trailblazer', 'Película conclusiva con amenaza alienígena', 2010, 'MOVIE', 2.0, 3, 1);

-- Iron-Blooded Orphans (2 temporadas)
INSERT INTO seasons (series_id, season_number, title, description, release_year, type, hours_length, chronological_order, episode_count) VALUES
(42, 1, 'Iron-Blooded Orphans Season 1', 'Primera temporada: Formación de Tekkadan', 2015, 'TV', 10.21, 1, 25),
(62, 2, 'Iron-Blooded Orphans Season 2', 'Segunda temporada: Consecuencias y batallas finales', 2016, 'TV', 10.21, 2, 25);

-- Gundam SEED (4 partes)
INSERT INTO seasons (series_id, season_number, title, description, release_year, type, hours_length, chronological_order, episode_count) VALUES
(33, 1, 'Gundam SEED', 'Historia original con Kira Yamato', 2002, 'TV', 20.42, 1, 50),
(35, 2, 'Gundam SEED Destiny', 'Secuela con nuevos protagonistas', 2004, 'TV', 20.42, 2, 50),
(36, 3, 'SEED C.E.73: Stargazer', 'Historia paralela con nuevos personajes', 2006, 'OVA', 0.75, 3, 3),
(37, 4, 'Gundam SEED Freedom', 'Película que continúa después de Destiny', 2024, 'MOVIE', 2.07, 4, 1);

-- Build Series (5 temporadas)
INSERT INTO seasons (series_id, season_number, title, description, release_year, type, hours_length, chronological_order, episode_count) VALUES
(48, 1, 'Gundam Build Fighters', 'Primera temporada con Sei y Reiji', 2013, 'TV', 10.42, 1, 25),
(49, 2, 'Gundam Build Fighters Try', 'Secuela con nuevos protagonistas', 2014, 'TV', 10.42, 2, 25),
(50, 3, 'Gundam Build Divers', 'Tercera temporada en mundo virtual', 2018, 'TV', 10.0, 3, 25),
(51, 4, 'Gundam Build Divers Re:RISE', 'Cuarta temporada con historia más seria', 2019, 'TV', 10.4, 4, 26),
(52, 5, 'Gundam Build Metaverse', 'Crossover especial de Build Series', 2023, 'ONA', 0.5, 5, 3);