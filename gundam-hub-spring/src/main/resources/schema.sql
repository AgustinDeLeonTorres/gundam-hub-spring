-- =========================
-- TABLA UNIVERSES
-- =========================
CREATE TABLE universes (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    description TEXT
);

-- =========================
-- TABLA SERIES
-- =========================
CREATE TABLE series (
    id BIGINT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    release_year INT,
    type VARCHAR(50),
    hours_length DOUBLE,
    universe_id BIGINT,
    FOREIGN KEY (universe_id) REFERENCES universes(id)
);

-- =========================
-- TABLA EPISODES
-- =========================
CREATE TABLE episodes (
    id BIGINT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    duration DOUBLE,
    episode_number INT,
    series_id BIGINT,
    FOREIGN KEY (series_id) REFERENCES series(id)
);