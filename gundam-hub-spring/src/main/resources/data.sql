-- =========================
-- UNIVERSOS
-- =========================
INSERT INTO universes (id, name, description) VALUES
(1, 'Universal Century (UC)', 'Línea de tiempo principal de Gundam'),
(2, 'Alternate Universe (AU)', 'Universos alternativos de Gundam');

-- =========================
-- SERIES UNIVERSAL CENTURY (UC)
-- =========================
-- Pre-Guerra de Un Año
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(1, 'Mobile Suit Gundam: The Origin', 2015, 'OVA', 6.0, 1),
(2, 'MS IGLOO: The Hidden One Year War', 2004, 'OVA', 1.5, 1),
(3, 'MS IGLOO: Apocalypse 0079', 2006, 'OVA', 1.5, 1),
(4, 'MS IGLOO 2: Gravity Front', 2006, 'OVA', 1.5, 1);

-- Guerra de Un Año
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(5, 'Mobile Suit Gundam 0079', 1979, 'TV', 17.56, 1),
(6, 'Mobile Suit Gundam: Cucuruz Doan''s Island', 2022, 'Movie', 1.75, 1),
(7, 'Mobile Suit Gundam: The 08th MS Team', 1996, 'OVA', 4.9, 1),
(8, 'Miller''s Report', 1998, 'Special', 0.6, 1),
(9, 'Thunderbolt: December Sky', 2016, 'Movie', 1.67, 1),
(10, 'Thunderbolt: Bandit Flower', 2017, 'Movie', 1.5, 1),
(11, 'Mobile Suit Gundam 0080: War in the Pocket', 1989, 'OVA', 2.45, 1),
(12, 'Mobile Suit Gundam: Requiem for Vengeance', 2024, 'ONA', 2.0, 1),
(13, 'Gundam Evolve (UC-relevant shorts)', 2001, 'Special', 1.07, 1);

-- Post-Guerra de Un Año
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(14, 'Mobile Suit Gundam 0083: Stardust Memory', 1991, 'OVA', 5.31, 1);

-- Conflictos de Gryps
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(15, 'Mobile Suit Zeta Gundam', 1985, 'TV', 20.42, 1),
(16, 'Mobile Suit Gundam ZZ', 1986, 'TV', 19.19, 1);

-- Segunda Neo-Zeon War
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(17, 'Mobile Suit Gundam: Char''s Counterattack', 1988, 'Movie', 2.0, 1);

-- Late UC
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(18, 'Mobile Suit Gundam Unicorn', 2010, 'OVA', 7.0, 1),
(19, 'Mobile Suit Gundam Twilight Axis', 2017, 'ONA', 0.43, 1),
(20, 'Mobile Suit Gundam Narrative', 2018, 'Movie', 1.5, 1),
(21, 'Mobile Suit Gundam Hathaway', 2021, 'Movie', 1.72, 1);

-- Far Future UC
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(22, 'Mobile Suit Gundam F91', 1991, 'Movie', 1.92, 1),
(23, 'Mobile Suit Victory Gundam', 1993, 'TV', 20.83, 1),
(24, 'G-Saviour', 2000, 'Live-action', 1.55, 1);

-- =========================
-- SERIES ALTERNATE UNIVERSE (AU)
-- =========================
-- Future Century (G Gundam)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(25, 'Mobile Fighter G Gundam', 1994, 'TV', 20.01, 2),
(26, 'Kidou Butouden G Gundam (Especiales)', 2004, 'OVA', 0.83, 2);

-- After Colony (Gundam Wing)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(27, 'Gundam Wing', 1995, 'TV', 20.01, 2),
(28, 'Endless Waltz', 1997, 'Movie', 1.5, 2);

-- After War (Gundam X)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(29, 'After War Gundam X', 1996, 'TV', 15.93, 2);

-- Correct Century (Turn A Gundam)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(30, 'Turn A Gundam', 1999, 'TV', 20.42, 2),
(31, 'Turn A Gundam: Earth Light', 2002, 'Movie', 2.0, 2),
(32, 'Turn A Gundam: Moonlight Butterfly', 2002, 'Movie', 2.17, 2);

-- Cosmic Era (Gundam SEED)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(33, 'Gundam SEED', 2002, 'TV', 20.42, 2),
(34, 'Gundam SEED MSV Astray', 2004, 'OVA', 0.17, 2),
(35, 'Gundam SEED Destiny', 2004, 'TV', 20.42, 2),
(36, 'SEED C.E.73: Stargazer', 2006, 'OVA', 0.75, 2),
(37, 'Gundam SEED Freedom', 2024, 'Movie', 2.07, 2);

-- Anno Domini (Gundam 00)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(38, 'Gundam 00', 2007, 'TV', 20.42, 2),
(39, '00: Awakening of the Trailblazer', 2010, 'Movie', 2.0, 2);

-- Advanced Generation (Gundam AGE)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(40, 'Gundam AGE', 2011, 'TV', 20.01, 2),
(41, 'Gundam AGE: Memory of Eden', 2013, 'OVA', 2.5, 2);

-- Post Disaster (Gundam IBO)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(42, 'Iron-Blooded Orphans', 2015, 'TV', 20.42, 2);

-- Ad Stella (Gundam Witch)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(43, 'The Witch from Mercury', 2022, 'TV', 9.8, 2);

-- Otros AUs Menores
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(44, 'Gundam-san', 2014, 'Special', 0.65, 2),
(45, 'Gundam Evolve (non-UC shorts)', 2001, 'Special', 1.07, 2),
(46, 'Gundam Moon', 2024, 'Short', 0.17, 2),
(47, 'SD Gundam Force', 2004, 'TV', 19.07, 2);

-- Build Series / Meta-universo
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(48, 'Gundam Build Fighters', 2013, 'TV', 10.42, 2),
(49, 'Gundam Build Fighters Try', 2014, 'TV', 10.42, 2),
(50, 'Gundam Build Divers', 2018, 'TV', 10.0, 2),
(51, 'Gundam Build Divers Re:RISE', 2019, 'TV', 10.4, 2),
(52, 'Gundam Build Metaverse', 2023, 'ONA', 0.5, 2);

-- Proyectos experimentales / raros
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(53, 'Gundam THE RIDE: A Baoa Qu', 2000, 'Short', 0.08, 2),
(54, 'Gundam Neo Experience 0087: Green Divers', 2001, 'Short', 0.4, 2),
(55, 'Gundam Reconguista in G (TV)', 2014, 'TV', 10.4, 2),
(56, 'Gundam Reconguista in G (Movies I-V)', 2019, 'Movie', 8.33, 2);

-- Gundam GQuuuuuuX (2025)
INSERT INTO series (id, title, release_year, type, hours_length, universe_id) VALUES
(57, 'Mobile Suit Gundam GQuuuuuuX: Beginning', 2025, 'Movie', 1.35, 2),
(58, 'Mobile Suit Gundam GQuuuuuuX (TV)', 2025, 'TV', 4.8, 2);
