-- =========================
-- TABLA UNIVERSOS (PRIMERO - no depende de nadie)
-- =========================
CREATE TABLE IF NOT EXISTS universes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

-- =========================
-- TABLA ERAS (SEGUNDO - depende de universes)
-- =========================
CREATE TABLE IF NOT EXISTS eras (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    universe_id BIGINT,
    chronological_order INT,
    is_canonical BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (universe_id) REFERENCES universes(id) ON DELETE CASCADE
);

-- =========================
-- TABLA SERIES (TERCERO - depende de universes y eras)
-- =========================
CREATE TABLE IF NOT EXISTS series (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    release_year INT,
    type VARCHAR(50),
    hours_length DOUBLE,
    universe_id BIGINT,
    era_id BIGINT,
    FOREIGN KEY (universe_id) REFERENCES universes(id) ON DELETE CASCADE,
    FOREIGN KEY (era_id) REFERENCES eras(id) ON DELETE CASCADE
);

-- =========================
-- TABLA TEMPORADAS (SEASONS) - CUARTO (depende de series)
-- =========================
CREATE TABLE IF NOT EXISTS seasons (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    series_id BIGINT NOT NULL,
    season_number INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    release_year INT,
    type ENUM('TV', 'MOVIE', 'OVA', 'SPECIAL', 'ONA') NOT NULL DEFAULT 'TV',
    hours_length DOUBLE,
    chronological_order INT,
    episode_count INT DEFAULT 0,
    poster_url VARCHAR(500),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (series_id) REFERENCES series(id) ON DELETE CASCADE
);

-- =========================
-- TABLA EPISODIOS (QUINTO - depende de seasons)
-- =========================
CREATE TABLE IF NOT EXISTS episodes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    season_id BIGINT,
    episode_number INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    duration_minutes INT,
    release_date DATE,
    is_filler BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (season_id) REFERENCES seasons(id) ON DELETE CASCADE
);