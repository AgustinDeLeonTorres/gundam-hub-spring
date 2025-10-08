-- Eliminar tablas si existen (en orden correcto por dependencias)
DROP TABLE IF EXISTS episodes;
DROP TABLE IF EXISTS series;
DROP TABLE IF EXISTS eras;
DROP TABLE IF EXISTS universes;

-- =========================
-- TABLA UNIVERSOS
-- =========================
CREATE TABLE universes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT
);

-- =========================
-- TABLA ERAS (NUEVA)
-- =========================
CREATE TABLE eras (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    universe_id BIGINT NOT NULL,
    chronological_order INT NOT NULL,
    is_canonical BOOLEAN DEFAULT true,
    FOREIGN KEY (universe_id) REFERENCES universes(id) ON DELETE CASCADE
);

-- =========================
-- TABLA SERIES
-- =========================
CREATE TABLE series (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    release_year INT,
    type VARCHAR(50),
    hours_length DECIMAL(5,2),
    universe_id BIGINT,
    era_id BIGINT,
    FOREIGN KEY (universe_id) REFERENCES universes(id) ON DELETE CASCADE,
    FOREIGN KEY (era_id) REFERENCES eras(id) ON DELETE SET NULL
);

-- =========================
-- TABLA EPISODIOS
-- =========================
CREATE TABLE episodes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    episode_number INT,
    duration_minutes INT,
    series_id BIGINT,
    FOREIGN KEY (series_id) REFERENCES series(id) ON DELETE CASCADE
);